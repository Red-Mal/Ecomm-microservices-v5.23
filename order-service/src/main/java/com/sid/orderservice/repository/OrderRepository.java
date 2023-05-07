package com.sid.orderservice.repository;

import com.sid.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Order repository.
 */
public interface OrderRepository extends JpaRepository<Order,Long> {

}
