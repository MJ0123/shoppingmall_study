package com.mall.service;

import java.util.List;

import com.mall.domain.GoodsViewVO;
import com.mall.domain.ReplyListVO;
import com.mall.domain.ReplyVO;

public interface ShopService {

	// 카테고리별 상품 리스트
	public List<GoodsViewVO> list(int catecode, int level) throws Exception;
	
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
}
