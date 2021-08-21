package com.vn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.entities.Product;
import com.vn.repository.CategoryRepository;
import com.vn.repository.ProductRepository;
import com.vn.vo.ProductVO;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	ProductRepository productRepository; // inject vào để dùng (được xây dựng sẵn các hàm)

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}
	
	@Override
	public List<ProductVO> readAll() {
		List<ProductVO> voList = new ArrayList<ProductVO>();
		List<Product> entities = productRepository.findAll();
		for (Product entity : entities) {
			ProductVO vo = new ProductVO();
			BeanUtils.copyProperties(entity, vo);
			vo.setCategory_id(entity.getCategory().getId());
			vo.setImagetext(entity.getImage());
			voList.add(vo);
		}
		return voList;
	}

	@Override
	public ProductVO create(ProductVO vo) {
		Product entity = new Product();
		BeanUtils.copyProperties(vo, entity); // copy thuộc tính của vo sang entity
		entity.setCategory(categoryRepository.findById(vo.getCategory_id()).get());
		entity.setImage(vo.getImage().getOriginalFilename());
		try {
			String localDate = LocalDate.now().toString();
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate);
			entity.setCreateDate(date);
			productRepository.save(entity);
			vo.setId(entity.getId());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	

	@Override
	public ProductVO update(ProductVO vo) {
		Optional<Product> optional = productRepository.findById(vo.getId());
		if (optional.isPresent()) {
			Product entity = optional.get();
			BeanUtils.copyProperties(vo, entity);
			entity.setCategory(categoryRepository.findById(vo.getCategory_id()).get());
			entity.setImage(vo.getImage().getOriginalFilename());
			try {
				String localDate = LocalDate.now().toString();
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate);
				entity.setCreateDate(date);
				productRepository.save(entity);
				vo.setId(entity.getId());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return vo;

	}

	@Override
	public ProductVO delete(Integer id) {
		ProductVO vo = new ProductVO();
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			Product entity = optional.get();
			BeanUtils.copyProperties(entity, vo);
			productRepository.delete(entity);
			return vo;
		} else {
			return null;
		}
	}

	@Override
	public ProductVO detail(Integer id) {
		ProductVO vo = new ProductVO();
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			Product entity = optional.get();
			BeanUtils.copyProperties(entity, vo);
			vo.setCategory_id(entity.getCategory().getId());
			return vo;
		} else {
			return null;
		}

	}
}
