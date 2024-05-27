package com.dosirak.hjh.service;

import java.util.List;

import com.dosirak.common.vo.ReplyVO;
import com.dosirak.common.vo.SearchVO;

public interface ReplyService {
	//목록
	List<ReplyVO> replyList(SearchVO search);
	boolean removeReply(int replyNo);
	boolean addReply(ReplyVO rvo);

	boolean updateReply(ReplyVO rvo);
	

}
