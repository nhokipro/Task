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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "`order`")
@Data
@SuperBuilder
@NoArgsConstructor
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name_order", length = 50, nullable = false)
	private String nameOrder;

	@Column(name = "number_of_item", nullable = false)
	private Integer numberOfItem;

	@Column(name = "note", length = 500)
	private String note;

	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(name = "date")
	private Date date;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;

}
