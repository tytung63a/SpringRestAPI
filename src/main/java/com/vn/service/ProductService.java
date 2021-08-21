package com.vn.service;

import java.util.List;
import java.util.Optional;

import com.vn.entities.Product;
import com.vn.vo.ProductVO;

public interface ProductService {

	List<ProductVO> readAll();

	ProductVO create(ProductVO vo);

	ProductVO detail(Integer id);

	ProductVO delete(Integer id);

	ProductVO update(ProductVO vo);

	Optional<Product> findById(Integer id);


}
