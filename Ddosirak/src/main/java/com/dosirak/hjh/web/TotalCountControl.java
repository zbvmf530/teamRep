package com.dosirak.hjh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.hjh.service.ReplyService;
import com.dosirak.hjh.service.ReplyServiceImpl;

public class TotalCountControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		//service, mapper에 반환할거 만들기
		ReplyService svc = new ReplyServiceImpl();
		int cnt = svc.getReplyCnt(Integer.parseInt(bno));
		System.out.println("댓글수"+cnt);
		
		//{"totalCount":10}
		resp.getWriter().print("{\"totalCount\":"+ cnt + "}");
				
	}

}
