package com.dosirak.hjh.service;

import java.util.List;

import com.dosirak.common.vo.BoardVO;
import com.dosirak.common.vo.SearchVO;

public interface BoardService {
	
	List<BoardVO> boardList(SearchVO search);//목록

	int getTotalBoard(SearchVO search); //전체건수

	boolean addBoard(BoardVO board);
	BoardVO getBoard(int boardNo);
	int addViewCnt(int boardNo); //조회수
	//수정
	boolean modifyBoard(BoardVO board);
	//삭제
	boolean delBoard(BoardVO board);


}
