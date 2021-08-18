package com.vn.vo;

import java.io.Serializable;

import com.vn.entities.Customer;
import com.vn.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Customer customer;

	private Role role;
}
