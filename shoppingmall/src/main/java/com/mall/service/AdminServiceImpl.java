package com.mall.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mall.domain.CategoryVO;
import com.mall.domain.GoodsVO;
import com.mall.domain.GoodsViewVO;
import com.mall.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO dao;

	// 카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}

	// 상품 등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		dao.register(vo);
	}

	// 상품 목록
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		System.out.println("서비스");
		return dao.goodslist();
	}

	// 상품 조회 + 카테고리 조인
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}

	// 상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
	}

	// 상품 삭제
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		dao.goodsDelete(gdsNum);
	}
}
