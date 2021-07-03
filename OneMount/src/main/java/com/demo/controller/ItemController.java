package com.demo.controller;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.ItemDto;
import com.demo.entity.Item;
import com.demo.service.IItemService;

@RestController
@RequestMapping(value = "api/v1/item")
public class ItemController {


	@Autowired
	private IItemService service;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping()
	public ResponseEntity<?> getAllItems(Pageable pageable) {

		Page<Item> itemPage = service.getAllItems(pageable);

		// convert entities --> dtos
		Page<ItemDto> dtoPages = itemPage.map(new Function<Item, ItemDto>() {

			@Override
			public ItemDto apply(Item entity) {
				ItemDto dto = modelMapper.map(entity, ItemDto.class);
				return dto;
			}
		});

		return new ResponseEntity<>(dtoPages, HttpStatus.OK);
	}


}
