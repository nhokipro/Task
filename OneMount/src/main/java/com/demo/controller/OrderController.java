package com.demo.controller;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.OrderDTO;
import com.demo.entity.Order;
import com.demo.form.OrderFormCreate;
import com.demo.service.IOrderService;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<?> getAllOrders(Pageable pageable) {
		Page<Order> entitiePage = orderService.getAllOrders(pageable);
		Page<OrderDTO> dtoPages = entitiePage.map(new Function<Order, OrderDTO>() {

			@Override
			public OrderDTO apply(Order entity) {
				OrderDTO dto = modelMapper.map(entity, OrderDTO.class);
				return dto;
			}
		});
		return new ResponseEntity<>(dtoPages, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createOrder(@RequestBody OrderFormCreate form) {
		orderService.createOrder(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

}
