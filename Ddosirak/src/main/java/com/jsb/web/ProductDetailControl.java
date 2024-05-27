package com.jsb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.common.Control;

public class ProductDetailControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code"); // 상품코드 get해서 code에 선언
		
		
		req.getRequestDispatcher("views/main/productDetail.tiles").forward(req, resp);

	}

}
