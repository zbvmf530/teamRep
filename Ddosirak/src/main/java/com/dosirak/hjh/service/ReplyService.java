package com.dosirak.hjh.service;

import java.util.List;

import com.dosirak.common.vo.ReplyVO;
import com.dosirak.common.vo.SearchVO;
import com.dosirak.common.vo.TmemberVO;

public interface ReplyService {
	//목록
	List<ReplyVO> replyList(SearchVO search);
	boolean removeReply(int replyNo);
	boolean addReply(ReplyVO rvo);
	int getReplyCnt(int boardNo); //댓글갯수
	boolean updateReply(ReplyVO rvo);

	TmemberVO checkMember(String id);

}
