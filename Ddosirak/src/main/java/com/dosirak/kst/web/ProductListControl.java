package com.dosirak.kst.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.common.vo.ProductVO;
import com.dosirak.kst.service.ProductService;
import com.dosirak.kst.service.ProductServiceImpl;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String main = req.getParameter("main");
		String sub = req.getParameter("sub");
		
	    ProductService svc = new ProductServiceImpl();

	    List<ProductVO> list = svc.productList(main, sub);
	    
	    req.setAttribute("main", main);
	    req.setAttribute("sub", sub);  
		req.setAttribute("productList", list);

		
		req.getRequestDispatcher("product/productList.tiles").forward(req, resp);
		
	}

}
