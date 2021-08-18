package com.vn.service;

import java.util.List;

import com.vn.vo.CategoryVO;

public interface CategoryService {
	List<CategoryVO> readAll();

	CategoryVO create(CategoryVO vo);

	CategoryVO detail(Integer id);

	CategoryVO delete(Integer id);

	CategoryVO update(CategoryVO vo);
}
