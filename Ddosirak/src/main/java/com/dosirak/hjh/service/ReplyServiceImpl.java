package com.dosirak.hjh.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dosirak.common.DataSource;
import com.dosirak.common.vo.ReplyVO;
import com.dosirak.common.vo.SearchVO;
import com.dosirak.hjh.mapper.ReplyMapper;

public class ReplyServiceImpl implements ReplyService{

	SqlSession session = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	
	@Override
	public List<ReplyVO> replyList(SearchVO search) {
		return mapper.replyListPaging(search);
	}

	@Override
	public boolean removeReply(int replyNo) {
		return mapper.deleteReply(replyNo) == 1;
	}

	@Override
	public boolean addReply(ReplyVO rvo) {
		return mapper.insertReply(rvo) == 1;
	}

	@Override
	public boolean updateReply(ReplyVO rvo) {
		return mapper.updateReply(rvo) == 1;
	}

	@Override
	public int getReplyCnt(int boardNo) {
		return mapper.replyCnt(boardNo);
	}

}
