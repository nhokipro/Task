package com.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "item")
@Data
@SuperBuilder
@NoArgsConstructor
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name_item", length = 50, nullable = false)
	private String nameItem;
	
	@Column(name = "type", length = 50, nullable = false)
	private String type;

	@Column(name = "price", nullable = false)
	private Double price;

	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(name = "date")
	private Date date;
	
	@OneToMany(mappedBy = "item")
	private List<OrderItem> orderItems;


}