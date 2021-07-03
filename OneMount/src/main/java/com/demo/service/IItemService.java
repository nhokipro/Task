package com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.entity.Item;

public interface IItemService {

	public Page<Item> getAllItems(Pageable pageable);

	public Item getItemByID(int id);

//	public void createMentor(MentorFormCreate formCreate);
}
