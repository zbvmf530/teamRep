package com.dosirak.hjh.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.common.vo.BoardVO;
import com.dosirak.common.vo.SearchVO;
import com.dosirak.hjh.service.BoardService;
import com.dosirak.hjh.service.BoardServiceImpl;


public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno, title, content 3개 파라미터 넘어옴
		//수정후목록으로 이동

		String bno = req.getParameter("bno");
		String title = req.getParameter("boardTitle");
		String content = req.getParameter("boardContent");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardVO vo = new BoardVO();
		SearchVO svo = new SearchVO();
	
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setBoardTitle(title);
		vo.setBoardContent(content);
		
		svo.setKeyword(kw);
		svo.setPage(Integer.parseInt(page));
		svo.setSearchCondition(sc);
		BoardService svc = new BoardServiceImpl();
		req.setAttribute("bno", vo);
		req.setAttribute("boardTitle", title);
		req.setAttribute("boardContent", content);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		String encodekw = URLEncoder.encode(kw, "utf-8"); //한글 encoding 처리
		
		if(svc.modifyBoard(vo)){
			System.out.println("수정성공");
			resp.sendRedirect("boardList.do");
		
		}else {
			System.out.println("수정실패");
		}

	}

}
