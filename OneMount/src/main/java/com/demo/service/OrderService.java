package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.entity.Item;
import com.demo.entity.Order;
import com.demo.entity.OrderItem;
import com.demo.form.OrderFormCreate;
import com.demo.repository.IOrderItemRepository;
import com.demo.repository.IOrderRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Autowired
	private IOrderItemRepository orderItemRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Page<Order> getAllOrders(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	@Override
	public void createOrder(OrderFormCreate form) {
		// convert entity to dto
		Order entity = modelMapper.map(form, Order.class);

		// create order
		Order order = orderRepository.save(entity);

		List<OrderItem> orderItems = new ArrayList<>();
		for (Integer id : form.getItemId()) {
			Item item = Item.builder().id(id).build();
			OrderItem orderItem = OrderItem.builder().item(item).order(order).build();
			orderItems.add(orderItem);
		}
		orderItemRepository.saveAll(orderItems);

	}

}
