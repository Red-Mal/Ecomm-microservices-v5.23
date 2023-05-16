package com.sid.orderservice.service;



import com.sid.orderservice.dto.InventoryResponse;
import com.sid.orderservice.dto.OrderLineItemsDto;
import com.sid.orderservice.dto.OrderRequest;
import com.sid.orderservice.event.OrderPlacedEvent;
import com.sid.orderservice.model.Order;
import com.sid.orderservice.model.OrderLineItems;
import com.sid.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;
    public String placeOrder(OrderRequest orderRequest){
        log.info("placeOrder Method");
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
       List<OrderLineItems> orderLineItems= orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
       order.setOrderLineItemsList(orderLineItems);

       List<String> skuCodes= order.getOrderLineItemsList()
               .stream()
               .map(OrderLineItems::getSkuCode)
               .toList();

        log.info("Call inventory");
        //Call Inventory Service, and place order if product is in stock
        InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
                        .uri("http://inventory-service/api/inventory",
                                uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                                .retrieve()
                                        .bodyToMono(InventoryResponse[].class)
                                                .block();
        log.info("inventoryResponse {}", Arrays.stream(inventoryResponseArray).count());

        boolean allProductsInStock=Arrays.stream(inventoryResponseArray)
                .allMatch((InventoryResponse::isInstock));
        /*if(!Boolean.TRUE.equals(allProductsInStock))
            throw new IllegalArgumentException("Product is not in Stock");
        orderRepository.save(order);*/
        if(allProductsInStock){
            log.info("Saving the order ...");
            orderRepository.save(order);

            try {
                log.info("Sending notification to kafka ...");
                kafkaTemplate.send("notificationTopic",new OrderPlacedEvent(order.getOrderNumber()));
            }
            catch(Exception ex)
            {
                log.info("Problem in Sending notification to kafka ... {}",ex.getMessage());
            }



            return "Order Placed Successfuly !!!";
        }else{
            throw new IllegalArgumentException("Product is not in Stock");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
