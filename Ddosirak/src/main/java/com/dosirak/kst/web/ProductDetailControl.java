package com.dosirak.kst.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.common.vo.ProductOptionVO;
import com.dosirak.common.vo.ProductVO;
import com.dosirak.kst.service.ProductService;
import com.dosirak.kst.service.ProductServiceImpl;

public class ProductDetailControl implements Control {
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int code = Integer.parseInt(req.getParameter("code")); // 상품코드 get해서 code에 선언

		ProductVO prod = new ProductVO();	
		ProductService svc = new ProductServiceImpl();
		
		
	    List<Map<String, Integer>> optionList = svc.getOptionsForProduct(code);
	    String prodName = svc.getName(code);
		List<Map<Integer, String>> review = svc.getReview(code);
	    int reviewCnt = svc.getReviewCnt(code);
	    double gradeAvg = svc.getGradeAvg(code);
	    String prodImage = svc.getImage(code);
	    
	    
	    
	    req.setAttribute("code", code);
	    req.setAttribute("reviewCnt", reviewCnt);
		req.setAttribute("optionList", optionList);
		req.setAttribute("name", prodName);
		req.setAttribute("reviews", review);
		req.setAttribute("gradeAvg", gradeAvg);
		req.setAttribute("prodImage", prodImage);
		
		
		
		req.getRequestDispatcher("product/productDetail.tiles").forward(req, resp);

	}

}
