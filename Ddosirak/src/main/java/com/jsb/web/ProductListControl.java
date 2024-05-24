package com.jsb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.common.Control;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String main = req.getParameter("main");
		String sub = req.getParameter("sub");
		
		
		
		req.getRequestDispatcher("views/main/productList.tiles").forward(req, resp);
		
	}

}
