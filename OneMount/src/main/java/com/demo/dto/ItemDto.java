package com.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemDto {
	private Integer id;
	private String type;
	private String nameItem;
	private Double price;
}


