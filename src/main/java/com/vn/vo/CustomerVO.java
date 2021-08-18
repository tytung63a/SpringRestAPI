package com.vn.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private byte actived;

	private byte admin;

	private String email;

	private String fullname;

	private String password;

	private String photo;

	private String username;

	private List<OrderVO> ordersVO;

}