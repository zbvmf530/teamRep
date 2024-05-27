package com.jsb.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dosirak.common.Control;
import com.dosirak.common.vo.ProductVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jsb.service.ProductService;
import com.jsb.service.ProductServiceImpl;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductService svc = new ProductServiceImpl();
		List<Map<String,String>> maincat = svc.getMainCat();

		// 주문수 많은 순으로 상품코드 가져오는 코드
		List<Map<String,Integer>> bestsellers = svc.getBestSeller();  
		List<Integer> bestItems = new ArrayList<>();
		for(Map<String,Integer> bs : bestsellers) {bestItems.add(Integer.parseInt(String.valueOf(bs.get("PRODUCT_CODE"))));}
		
		
		// 주문수 많은 상품코드로 상품정보 불러오는 코드
		List<ProductVO> bestProducts = new ArrayList<>(); 
		for(Integer prodCode: bestItems) 
		{bestProducts.add(svc.getProduct(prodCode));}
		bestProducts.forEach(item->System.out.println(item));
		
		// 상단 네비메뉴 구성용 코드
		List<String>catList = new ArrayList<>();
		for (Map<String, String> cat : maincat) {
			catList.add(cat.get("MAIN_CATEGORY"));
		}
		
		Map<String,List<String>> TotalList = new HashMap<>();
		
		for(String main: catList) {
			List<String> subcategory = svc.getSubCat(main);
			TotalList.put(main, subcategory);
		}
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(TotalList);
		System.out.println(json);
		req.setAttribute("totalList", TotalList);
		req.setAttribute("json", json);
		req.setAttribute("bestProducts", bestProducts);
		
		
		HttpSession session = req.getSession();
				
		if(session.getAttribute("logId") == null) {
			session.setAttribute("logId", "null");
			if(session.getAttribute("auth")==null) 
			{session.setAttribute("auth", "null");}
			
		}
		
		System.out.println("실행!");
		req.getRequestDispatcher("views/main/main.tiles").forward(req, resp);
	}

}
