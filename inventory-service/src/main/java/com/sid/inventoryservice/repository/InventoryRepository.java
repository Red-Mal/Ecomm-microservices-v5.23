package com.sid.inventoryservice.repository;

import com.sid.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
  //  List<Inventory> findBySkuCode(String skuCode);
  Optional<Inventory> findBySkuCode(String skuCode);
}