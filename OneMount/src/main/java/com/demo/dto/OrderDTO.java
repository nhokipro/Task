package com.demo.dto;


import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
	private Integer id;
	private String nameOrder;
	private Date date;
	private Integer numberOfItem;
	private String note;
}

