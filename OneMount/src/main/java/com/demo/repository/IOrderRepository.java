package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
	public Order findByNameOrder(String nameOrder);


}
