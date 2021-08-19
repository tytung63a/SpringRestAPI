package com.vn.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

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
	private String username;

	@Column
	private byte actived;

	@Column
	private String email;

	@Column
	private String fullname;

	@Column
	private String password;

	@OneToMany(mappedBy = "customer")
	private List<CustomerRole> customerRoles;

}