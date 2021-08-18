package com.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vn.service.CategoryService;
import com.vn.vo.CategoryVO;

@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@GetMapping("/category")
	public List<CategoryVO> findAll() {
		return categoryService.readAll();
	}

	@GetMapping("/category/{id}")
	public CategoryVO detail(@PathVariable Integer id) {
		return categoryService.detail(id);
	}

	@PostMapping("/category")
	public CategoryVO create(@RequestBody CategoryVO vo) {
		return categoryService.create(vo);
	}

	@PutMapping("/category")
	public CategoryVO update(@RequestBody CategoryVO vo) {
		return categoryService.update(vo);
	}

	@DeleteMapping("category/{id}")
	public CategoryVO delete(@PathVariable Integer id) {
		return categoryService.delete(id);
	}

}
