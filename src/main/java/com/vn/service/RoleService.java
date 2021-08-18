package com.vn.service;

import java.util.List;

import com.vn.vo.RoleVO;

public interface RoleService {
	List<RoleVO> getAll();

	RoleVO create(RoleVO vo);

	RoleVO detail(Integer id);

	RoleVO delete(Integer id);

	RoleVO update(RoleVO vo);
}
