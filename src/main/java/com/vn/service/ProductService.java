package com.vn.service;

import java.util.List;

import com.vn.vo.ProductVO;

public interface ProductService {

	List<ProductVO> readAll();

	ProductVO create(ProductVO vo);

	ProductVO detail(Integer id);

	ProductVO delete(Integer id);

	ProductVO update(ProductVO vo);


}
