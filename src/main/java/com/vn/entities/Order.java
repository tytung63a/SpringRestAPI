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
 * The persistent class for the order database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate;

	private int status;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "order")
	private List<Orderdetail> orderdetails;

}