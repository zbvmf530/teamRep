package com.dosirak.jsb.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.common.vo.ProductVO;
import com.dosirak.jsb.service.ProductService;
import com.dosirak.jsb.service.ProductServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProductJsonControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService svc = new ProductServiceImpl();
		ProductVO product = svc.getProduct(Integer.parseInt(req.getParameter("prodCode")));
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(product);
		resp.getWriter().print(json);
	}

}
