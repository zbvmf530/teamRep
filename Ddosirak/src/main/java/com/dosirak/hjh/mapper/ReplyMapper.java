package com.dosirak.hjh.mapper;

import java.util.List;

import com.dosirak.common.vo.ReplyVO;
import com.dosirak.common.vo.SearchVO;


public interface ReplyMapper {
	
	//댓글목록
	List<ReplyVO> replyList(int boardNo);
	List<ReplyVO> replyListPaging(SearchVO search);
	//댓글삭제
	int deleteReply(int replyNo);
	//댓글등록
	int insertReply(ReplyVO vro);


	int updateReply(ReplyVO vro);
	

}
