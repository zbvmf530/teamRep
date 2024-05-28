package com.dosirak.ksh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;

public class SignupForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String json = req.getParameter("navmenu");
		System.out.println(json);
		String  path = "main/signupForm.tiles";
		req.setAttribute("json", json);
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
