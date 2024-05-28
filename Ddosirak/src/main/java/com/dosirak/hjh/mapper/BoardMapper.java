package com.dosirak.hjh.mapper;

import java.util.List;

import com.dosirak.common.vo.BoardVO;
import com.dosirak.common.vo.SearchVO;



public interface BoardMapper {

	List<BoardVO> boardList(SearchVO search); //전체목록가져오기
	List<BoardVO> boardListPaging(SearchVO search); //10개씩 리스트

	
	int getTotalCnt(SearchVO search);
	int insertBoard(BoardVO board);
	BoardVO selectBoard(int boardNo);
	int updateViewCnt(int boardNo);
	int updateBoard(BoardVO board); //수정처리
	int deleteBoard(BoardVO board); //삭제


}
