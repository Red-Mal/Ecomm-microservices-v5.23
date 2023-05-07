package com.sid.inventoryservice.controller;

import com.sid.inventoryservice.dto.InventoryResponse;
import com.sid.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Inventory controller.
 */
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    /**
     * Is in stock list.
     *
     * @param skuCode the sku code
     * @return the list
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam(required=false) List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
