package com.vn.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the customer database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private byte actived;

	@Column
	private byte admin;

	@Column
	private String email;

	@Column
	private String fullname;

	@Column
	private String password;

	@Column
	private String photo;

	@Column
	private String username;

	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<CustomerRole> customerRoles;

}