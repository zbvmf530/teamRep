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
		
		BoardVO vo = new BoardVO();
	
		vo.setBoardNo(Integer.parseInt(bno));
	
		BoardService svc = new BoardServiceImpl();
		if(svc.delBoard(vo)){
			System.out.println("삭제성공");
			resp.sendRedirect("boardList.do");
		}else {
			System.out.println("삭제실패");
		}
	

	}

}
