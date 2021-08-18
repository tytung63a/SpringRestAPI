package com.vn.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the orderdetail database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM Orderdetail o")
public class Orderdetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double price;

	private int quantity;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

}