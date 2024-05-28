package com.dosirak.hjh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.common.vo.BoardVO;
import com.dosirak.hjh.service.BoardService;
import com.dosirak.hjh.service.BoardServiceImpl;

public class RemoveControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno)); 
		String path = "board/deleteBoard.tiles";
		vo.setBoardNo(Integer.parseInt(bno));
	
		
		System.out.println("번호"+bno);
		if(svc.delBoard(vo)){
			System.out.println("삭제성공");
			resp.sendRedirect("boardList.do");
			return;
		}else {
			System.out.println("삭제실패");
			resp.sendRedirect("boardInfo.do");
		}
		req.getRequestDispatcher(path).forward(req, resp);

	}

}
