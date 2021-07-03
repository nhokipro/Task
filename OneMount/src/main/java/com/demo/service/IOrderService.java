package com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.entity.Order;
import com.demo.form.OrderFormCreate;


public interface IOrderService {


	public Page<Order> getAllOrders(Pageable pageable);

	void createOrder(OrderFormCreate form);
	
//	public void createClass(ClassFormCreate form);
}
