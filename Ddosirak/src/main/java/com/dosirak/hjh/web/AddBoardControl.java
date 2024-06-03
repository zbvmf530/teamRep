package com.dosirak.hjh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dosirak.common.Control;
import com.dosirak.common.vo.BoardVO;
import com.dosirak.common.vo.TmemberVO;
import com.dosirak.hjh.service.BoardService;
import com.dosirak.hjh.service.BoardServiceImpl;
import com.dosirak.ksh.service.MemberService;
import com.dosirak.ksh.service.MemberServiceImpl;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String savePath =req.getServletContext().getRealPath("imgs");
		int maxSize = 5 * 1024 * 1024;
		HttpSession session = req.getSession();
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize,"utf-8",new DefaultFileRenamePolicy());
		String auth = session.getAttribute("auth").toString();
		String title = mr.getParameter("boardTitle");
		String content = mr.getParameter("boardContent");
		String id = session.getAttribute("logId").toString();
		String category = mr.getParameter("selectCategory");
		String img = mr.getFilesystemName("myImg");
		String product = mr.getParameter("selectProduct").toString();
		
		String path = "board/addBoard.tiles";
		MemberService tvc = new MemberServiceImpl();
		System.out.println("id = "+id);
		System.out.println("auth = "+auth);
		
		TmemberVO mvo = tvc.getMember(id);
		if(mvo == null) {
			System.out.println("실패");
			req.setAttribute("message", "권한이 없습니다");
			req.getRequestDispatcher(path).forward(req, resp);
			return;
		}
		
		BoardVO vo = new BoardVO();
		vo.setBoardTitle(title);
		vo.setBoardContent(content);
		vo.setMemberId(id);
		vo.setCategory(category);
		vo.setBoardImg(img);
		vo.setProdCode(product);
		
		System.out.println("이미지" + img);
		
		BoardService svc = new BoardServiceImpl();
		if (svc.addBoard(vo)) {
			System.out.println("등록성공");
			if (category.equals("공지사항")) {
				System.out.println("공지" + category);
				resp.sendRedirect("./boardList.do?boardType=N");
				return;
			} else {
				System.out.println("카테" + category);
				resp.sendRedirect("./boardList.do?boardType=Q");
				return;
			}
		} else {
			System.out.println("등록실패");
		}

	}

}
