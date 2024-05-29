package com.dosirak.jsb.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.common.vo.ReplyVO;
import com.dosirak.hjh.service.ReplyService;
import com.dosirak.hjh.service.ReplyServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UpdateControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/json;charset=utf-8");
		
		String reply = req.getParameter("reply");
	
		String replyNo = req.getParameter("rno");
		
		Map<String, Object> result = new HashMap<>(); 
		ReplyVO vo = new ReplyVO();
		

		vo.setReplyContent(reply);
		vo.setReplyNo(Integer.parseInt(replyNo));

		ReplyService svc = new ReplyServiceImpl();
		if(svc.updateReply(vo)) {
			result.put("retCode", "OK");
		}else {
			result.put("retCode", "NG");
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);
		
		resp.getWriter().print(json);
	}

}
