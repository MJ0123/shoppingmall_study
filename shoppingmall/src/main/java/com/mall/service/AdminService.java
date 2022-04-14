package com.mall.service;

import java.util.List;

import com.mall.domain.CategoryVO;

public interface AdminService {

	// 카테고리
	public List<CategoryVO> category() throws Exception;
}
