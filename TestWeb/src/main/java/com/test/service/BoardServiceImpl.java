package com.test.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.board.BoardVO;
import com.test.common.DataSource;
import com.test.mapper.BoardMapper;

public class BoardServiceImpl implements BoardService{
	
	SqlSession session = DataSource.getInstance().openSession(true);
	BoardMapper mapper = session.getMapper(BoardMapper.class);
	@Override
	public List<BoardVO> boardList() {
		return mapper.boardList();
	}
}
