package com.dosirak.hjh.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.common.vo.ReplyVO;
import com.dosirak.common.vo.SearchVO;
import com.dosirak.hjh.service.ReplyService;
import com.dosirak.hjh.service.ReplyServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=UTF-8");
		
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		page = page ==null ? "1" : page;
		
		SearchVO search = new SearchVO();
		search.setBoardNo(Integer.parseInt(bno));
		search.setRpage(Integer.parseInt(page));
		
		
		//json포멧의 데이터 반환
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO>list=svc.replyList(search);
				
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		
		resp.getWriter().print(json);
	}

}
