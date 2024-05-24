package com.ksh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ksh.service.MemberService;
import com.ksh.service.MemberServiceImpl;
import com.team.common.Control;
import com.team.vo.TmemberVO;

public class tLoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");


		//System.out.println(id+", "+pw);
		MemberService svc = new MemberServiceImpl();
		boolean login = svc.login(id, pw);
		System.out.println(id+pw);
		System.out.println(login);
		if (login) {
			HttpSession session = req.getSession();
			
			// 권한 확인을 위해 회원정보를 VO객체 형식으로 가져오는 코드로 변경했습니다.(2024-05-24)
			//session.setAttribute("logId", id);
			
			TmemberVO mvo = svc.getMember(id);
			session.setAttribute("logId", mvo.getMemberId());
			session.setAttribute("auth", mvo.getAuthority());
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
