package com.dosirak.hjh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dosirak.common.vo.BoardVO;
import com.dosirak.common.vo.SearchVO;
import com.dosirak.common.vo.TmemberVO;




public interface BoardMapper {

	List<BoardVO> boardList(SearchVO search); //전체목록가져오기
	List<BoardVO> boardListPaging(SearchVO search); //10개씩 리스트

	int getTotalCnt(SearchVO search); // 글 갯수
	int insertBoard(BoardVO board);	//글 등록
	BoardVO selectBoard(int boardNo);	//글 세부
	int updateViewCnt(int boardNo);	//글 조회수
	int updateBoard(BoardVO board); //글 수정
	int deleteBoard(BoardVO board); //글 삭제
	
	TmemberVO tselectMember(@Param("id") String id, @Param("pw") String pw);
	TmemberVO checkMember(String id);
	
	
	
	
	

}
