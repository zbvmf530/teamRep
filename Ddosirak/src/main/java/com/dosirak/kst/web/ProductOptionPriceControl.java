package com.dosirak.kst.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.kst.service.ProductService;
import com.dosirak.kst.service.ProductServiceImpl;
import com.google.gson.Gson;

public class ProductOptionPriceControl implements Control {
    
	private ProductService svc = new ProductServiceImpl();

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductService svc = new ProductServiceImpl();

		String option = req.getParameter("option");
		int code = Integer.parseInt(req.getParameter("code"));
		int prodCode = Integer.parseInt(req.getParameter("prodCode"));
		
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter out = resp.getWriter()) {
        	int price = svc.calculatePrice(code);
            Gson gson = new Gson();
            String jsonResponse = gson.toJson(price);
            out.print(jsonResponse);
            out.flush();
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try (PrintWriter out = resp.getWriter()) {
                out.print("{\"error\": \"가격 정보를 가져오는 중 오류가 발생했습니다.\"}");
                out.flush();
            }
        }
    }
}


