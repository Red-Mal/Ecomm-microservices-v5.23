package com.sid.orderservice.repository;

import com.sid.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Order repository.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
