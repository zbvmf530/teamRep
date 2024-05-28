package com.dosirak.hjh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.common.vo.BoardVO;
import com.dosirak.hjh.service.BoardService;
import com.dosirak.hjh.service.BoardServiceImpl;


public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String title = req.getParameter("boardTitle");
		String content = req.getParameter("boardContent");
//		String memberId = req.getParameter("memberId");
		String category = req.getParameter("selectCategory");
		
		String path = "board/addBoard.tiles";
		BoardService svc = new BoardServiceImpl();
		
		
		BoardVO board = new BoardVO();
		board.setBoardTitle(title);
		board.setBoardContent(content);
//		vo.setMemberId(memberId);
		board.setCategory(category);
		
		System.out.println("제목"+title);
		System.out.println("내용"+content);
		System.out.println("카테고리"+category);
	
		
		if(svc.addBoard(board)){
			System.out.println("등록성공");
			resp.sendRedirect("boardList.do");
			return;
						
		
		}else {
			System.out.println("등록실패");
		}
	
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
