package com.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vn.service.ProductService;
import com.vn.vo.ProductVO;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/product")
	public List<ProductVO> findAll() {
		return productService.readAll();
	}

	@GetMapping("/product/{id}")
	public ProductVO detail(@PathVariable Integer id) {
		return productService.detail(id);
	}

	@PostMapping("/product")
	public ProductVO create(@Validated @RequestBody ProductVO vo, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			return productService.create(vo);
		}
		else {
			return null;
		}
	}

	@PutMapping("/product")
	public ProductVO update(@RequestBody ProductVO vo) {
		return productService.update(vo);
	}

	@DeleteMapping("product/{id}")
	public ProductVO delete(@PathVariable Integer id) {
		return productService.delete(id);
	}

}
