package com.dosirak.hjh.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.common.PageDTO;
import com.dosirak.common.vo.BoardVO;
import com.dosirak.common.vo.SearchVO;
import com.dosirak.hjh.service.BoardService;
import com.dosirak.hjh.service.BoardServiceImpl;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "board/boardList.tiles";
		SearchVO search = new SearchVO();
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		page = page == null ? "1" : page;
		search.setPage(Integer.parseInt(page));
		search.setKeyword(kw);
		search.setSearchCondition(sc);

		BoardService svc = new BoardServiceImpl();

		PageDTO pageDTO = new PageDTO(Integer.parseInt(page), svc.getTotal(search));

//		svc.replyCnt()

		List<BoardVO> list = svc.boardList(search);
		req.setAttribute("boardList", list);
		for (BoardVO boardVO : list) {
			System.out.println(boardVO.toString());
		}
		req.setAttribute("paging", pageDTO);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);

		req.getRequestDispatcher(path).forward(req, resp);
	}

}
