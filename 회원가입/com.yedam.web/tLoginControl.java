package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.TmemberVO;

public class tLoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		MemberService svc = new MemberServiceImpl();
		boolean login = svc.login(id, pw);
		System.out.println(id+pw);
		System.out.println(login);
		if (login) {
			HttpSession session = req.getSession();
			session.setAttribute("logId", id);

			// 관리자, 회원.
//			if (mvo.getUserResp().equals("Admin"))
//				resp.sendRedirect("memberList.do");
//			else
//				resp.sendRedirect("main.do");
			
			resp.sendRedirect("main.do");
			System.out.println("성공"+id);

		} else {
			System.out.println("실패");
			resp.sendRedirect("tloginForm.do");

		}
	}

}
