package com.jsb.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsb.service.OrderDetailService;
import com.jsb.service.OrderDetailServiceImpl;
import com.jsb.service.OrderService;
import com.jsb.service.OrderServiceImpl;
import com.team.common.Control;
import com.team.vo.OrderDetailVO;
import com.team.vo.OrderVO;

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
		req.getRequestDispatcher("views/main/mypage.tiles").forward(req, resp);
	}

}
