package com.dosirak.jsb.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dosirak.common.Control;
import com.dosirak.common.vo.OrderDetailVO;
import com.dosirak.common.vo.OrderVO;
import com.dosirak.jsb.service.OrderDetailService;
import com.dosirak.jsb.service.OrderDetailServiceImpl;
import com.dosirak.jsb.service.OrderService;
import com.dosirak.jsb.service.OrderServiceImpl;

public class MypageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderService svc = new OrderServiceImpl();
		HttpSession session = req.getSession();
		OrderDetailService dsvc = new OrderDetailServiceImpl();
		
		String userId = session.getAttribute("logId").toString();
		
		List<OrderVO> ovo = svc.getOrderList(userId);
		
		ovo.forEach(item->{
			System.out.println(item);
			System.out.println("----------------");
			List<OrderDetailVO> detailList = dsvc.getOrderDetail(item);
			
			detailList.forEach(detail->{System.out.println(detail);});
			});
		
		
		req.setAttribute("json", req.getParameter("navmenu"));
		req.getRequestDispatcher("main/mypage.tiles").forward(req, resp);
	}

}
