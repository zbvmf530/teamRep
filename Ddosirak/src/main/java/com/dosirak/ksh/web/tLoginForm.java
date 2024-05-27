package com.dosirak.ksh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;

public class tLoginForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String json = req.getParameter("navmenu");
		System.out.println("로그인 폼 컨트롤 호출");
		System.out.println(json);
		req.setAttribute("navmenu", json);
		String path = "main/tloginForm.tiles";
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
