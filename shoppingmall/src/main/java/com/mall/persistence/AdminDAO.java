package com.mall.persistence;

import java.util.List;

import com.mall.domain.CategoryVO;

public interface AdminDAO {

	// 카테고리
	public List<CategoryVO> category() throws Exception;
}
