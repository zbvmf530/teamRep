package com.dosirak.ksh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dosirak.common.Control;

public class LogOutControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		session.invalidate(); // 세션객체 삭제
		session = req.getSession();
		
		if(session.getAttribute("logId") == null) {
			session.setAttribute("logId", "null");
			if(session.getAttribute("auth")==null) 
			{session.setAttribute("auth", "null");}
			
		}
		resp.sendRedirect("main.do");
	}

}
