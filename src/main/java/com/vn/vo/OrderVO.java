package com.vn.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	private int status;

	private CustomerVO customerVO;

	private List<OrderdetailVO> orderdetailsVO;

}
