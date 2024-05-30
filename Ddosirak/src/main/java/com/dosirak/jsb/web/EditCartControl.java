package com.dosirak.jsb.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.common.vo.CartVO;
import com.dosirak.jsb.service.CartService;
import com.dosirak.jsb.service.CartServiceImpl;

public class EditCartControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CartVO cvo = new CartVO();
		cvo.setCartNo(Integer.parseInt(req.getParameter("cartNo")));
		cvo.setCount(Integer.parseInt(req.getParameter("count")));
		cvo.setPrice(Integer.parseInt(req.getParameter("price")));
		
		CartService svc = new CartServiceImpl();
		boolean updateCart = svc.updateCart(cvo);
		
		System.out.println(cvo);
		System.out.println(updateCart);
		
		if(updateCart) {
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
			// {"retCode":"NG"}
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}
	}

}
