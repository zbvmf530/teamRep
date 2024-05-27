package com.jsb.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsb.service.ProductService;
import com.jsb.service.ProductServiceImpl;
import com.team.common.Control;
import com.team.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String main = req.getParameter("main");
		String sub = req.getParameter("sub");
		
	    ProductService svc = new ProductServiceImpl();

	    List<ProductVO> list = svc.productList(main);
	    
	    req.setAttribute("main", main);
	    req.setAttribute("sub", sub);  
		req.setAttribute("productList", list);

		
		req.getRequestDispatcher("views/main/productList.tiles").forward(req, resp);
		
	}

}
