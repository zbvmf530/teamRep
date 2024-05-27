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
		
		req.getRequestDispatcher(path).forward(req, resp);
		
		BoardVO vo = new BoardVO();
		vo.setBoardTitle(title);
		vo.setBoardContent(content);
//		vo.setMemberId(memberId);
		vo.setCategory(category);
		
		System.out.println("제목"+title);
		System.out.println("내용"+content);
		System.out.println("카테"+category);
	
		
		if(svc.addBoard(vo)){
			System.out.println("등록성공");
			resp.sendRedirect("boardList.do");
			
		
		}else {
			System.out.println("등록실패");
		}
	
	}

}
