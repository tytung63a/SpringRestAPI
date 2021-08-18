package com.vn.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the product database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private int available;

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate;

	@Column
	private String image;

	@Column
	private String name;

	@Column
	private double price;

	@OneToMany(mappedBy = "product")
	private List<Orderdetail> orderDetails;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

}