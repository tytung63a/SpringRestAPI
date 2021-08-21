package com.vn.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1668807182825889537L;

	private Long id;

	private Integer appUserVO_id;

	private Integer appRoleVO_id;

}