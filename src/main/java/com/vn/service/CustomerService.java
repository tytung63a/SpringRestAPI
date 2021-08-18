package com.vn.service;

import java.util.List;

import com.vn.vo.CustomerVO;

public interface CustomerService {
	List<CustomerVO> readAll();

	CustomerVO create(CustomerVO vo);

	CustomerVO detail(Integer id);

	CustomerVO delete(Integer id);

	CustomerVO update(CustomerVO vo);
}
