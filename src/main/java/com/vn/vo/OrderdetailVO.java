package com.vn.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderdetailVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private double price;

	private int quantity;

	private OrderVO orderVO;

	private ProductVO productVO;
}
