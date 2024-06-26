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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CartControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartService svc = new CartServiceImpl();
		List<CartVO> cartList = svc.cartList();
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(cartList);
		resp.getWriter().print(json);
	}
}
