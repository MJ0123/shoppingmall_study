package com.mall.persistence;

import java.util.List;

import com.mall.domain.CartListVO;
import com.mall.domain.CartVO;
import com.mall.domain.GoodsViewVO;
import com.mall.domain.ReplyListVO;
import com.mall.domain.ReplyVO;

public interface ShopDAO {

	// 카테고리별 상품 리스트 : 1차 분류
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception;
	
	// 카테고리별 상품 리스트 : 2차 분류
	public List<GoodsViewVO> list(int cateCode) throws Exception;
	
	// 상품 조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	// 상품평(댓글) 작성
	public void registReply(ReplyVO reply) throws Exception;
	
	// 상품평(댓글) 리스트
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;
	
	// 상품평(댓글) 삭제
	public void deleteReply(ReplyVO reply) throws Exception;
	
	// 아이디 체크
	public String idCheck(int repNum) throws Exception;
	
	// 상품평(댓글) 수정
	public void modifyReply(ReplyVO reply) throws Exception;
	
	// 카트 담기
	public void addCart(CartVO cart) throws Exception;
	
	// 카트 리스트
	public List<CartListVO> cartList(String userId) throws Exception;
}
