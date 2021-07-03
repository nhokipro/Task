package com.demo.form;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class OrderFormCreate {
	private Integer id;
	private String nameOrder;
	private String note;
	private List<Integer> itemId;
	private Integer numberOfItem;
	public OrderFormCreate(Integer id, String nameOrder, String note, List<Integer> itemId, Integer numberOfItem) {
		super();
		this.id = id;
		this.nameOrder = nameOrder;
		this.note = note;
		this.itemId = itemId;
		this.numberOfItem = itemId.size();
	}
	
	
	
}
