package com.mall.service;

import java.util.List;

import com.mall.domain.CategoryVO;
import com.mall.domain.GoodsVO;

public interface AdminService {

	// 카테고리
	public List<CategoryVO> category() throws Exception;
	
	// 상품 등록
	public void register(GoodsVO vo) throws Exception;
}
