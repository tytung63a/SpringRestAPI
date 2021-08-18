package com.vn.vo;

import java.io.Serializable;
import java.util.List;

import com.vn.entities.CustomerRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;
	
	private List<CustomerRole> customerRoles;
}
