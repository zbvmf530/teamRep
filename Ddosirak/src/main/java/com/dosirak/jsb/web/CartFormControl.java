package com.dosirak.jsb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dosirak.common.Control;

public class CartFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if(session.getAttribute("logId").toString().equals("none")) {
			session.setAttribute("logId", "none");
			req.getRequestDispatcher("main/tloginForm.tiles").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("main/cartpage.tiles").forward(req, resp);
		}
	}

}
