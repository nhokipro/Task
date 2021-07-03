package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Item;
import com.demo.repository.IItemRepository;
import com.demo.repository.IOrderItemRepository;

@Service
@Transactional
public class ItemService implements IItemService {


	@Autowired
	private IItemRepository itemRepository;

	@Autowired
	private IOrderItemRepository orderItemRepository;


	@Override
	public Page<Item> getAllItems(Pageable pageable) {
		return itemRepository.findAll(pageable);
	}

	@Override
	public Item getItemByID(int id) {
		return itemRepository.findById(id).get();
	}
}
