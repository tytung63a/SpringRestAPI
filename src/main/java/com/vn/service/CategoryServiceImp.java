package com.vn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.entities.Category;
import com.vn.repository.CategoryRepository;
import com.vn.vo.CategoryVO;
@Service
public class CategoryServiceImp implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryVO> readAll() {
		List<CategoryVO> voList = new ArrayList<CategoryVO>();
		List<Category> entities = categoryRepository.findAll();
		for (Category entity : entities) {
			CategoryVO vo = new CategoryVO();
			BeanUtils.copyProperties(entity, vo);
			voList.add(vo);
		}
		return voList;
	}

	@Override
	public CategoryVO create(CategoryVO vo) {
		Category entity = new Category();
		BeanUtils.copyProperties(vo, entity);
		categoryRepository.save(entity);
		vo.setId(entity.getId());
		return vo;
	}

	@Override
	public CategoryVO detail(Integer id) {
		CategoryVO vo = new CategoryVO();
		Optional<Category> optional = categoryRepository.findById(id);
		if(optional.isPresent()) {
			Category entity = optional.get();
			BeanUtils.copyProperties(entity, vo);
			return vo;
		}
		else {
			return null;
		}
		
	}

	@Override
	public CategoryVO delete(Integer id) {
		CategoryVO vo = new CategoryVO();
		Optional<Category> optional = categoryRepository.findById(id);
		if (optional.isPresent()) {
			Category entity = optional.get();
			BeanUtils.copyProperties(entity, vo);
			categoryRepository.delete(entity);
			return vo;
		} else {
			return null;
		}
	}

	@Override
	public CategoryVO update(CategoryVO vo) {
		Optional<Category> optional = categoryRepository.findById(vo.getId());
		if(optional.isPresent()) {
			Category entity = optional.get();
			BeanUtils.copyProperties(vo, entity);
			categoryRepository.save(entity);
			return vo;
		}
		else {
			return null;
		}
	}

}
