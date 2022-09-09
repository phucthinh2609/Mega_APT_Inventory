package com.cg.repository;

import com.cg.model.Order;
import com.cg.model.ProductMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

}
