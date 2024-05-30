package com.dosirak.hjh.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dosirak.common.DataSource;
import com.dosirak.common.vo.BoardVO;
import com.dosirak.common.vo.SearchVO;
import com.dosirak.common.vo.TmemberVO;
import com.dosirak.hjh.mapper.BoardMapper;

public class BoardServiceImpl implements BoardService {
	SqlSession session = DataSource.getInstance().openSession(true);
	BoardMapper mapper = session.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList(SearchVO search) {
		return mapper.boardListPaging(search);
	}

	@Override
	public int getTotalBoard(SearchVO search) {
		return mapper.getTotalCnt(search);
	}

	@Override
	public boolean addBoard(BoardVO board) {
		return mapper.insertBoard(board) == 1;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		return mapper.selectBoard(boardNo);
	}

	@Override
	public int addViewCnt(int boardNo) {
		return mapper.updateViewCnt(boardNo);
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		return mapper.updateBoard(board) == 1;
	}

	@Override
	public boolean delBoard(BoardVO board) {
		return mapper.deleteBoard(board) == 1;
	}


}
