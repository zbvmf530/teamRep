package com.dosirak.hjh.web;

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


public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		//원본글, 댓글작성자, 댓글내용
//		String content = req.getParameter("content");
		String replyer = req.getParameter("memberId");
		String reply = req.getParameter("replyContent");
		String bno = req.getParameter("bno");
		String path = "Reply/addReply.tiles";	
		
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReplyContent(reply);
		rvo.setMemberId(replyer);
		
		Map<String, Object> result = new HashMap<>(); 
		
//		MemberVO mvo = rvo.checkMember(replyer);
//		if(mvo == null) {
//			
//			req.setAttribute("message", "권한이 없습니다");
//			req.getRequestDispatcher(path).forward(req, resp);
//			return;
//		}
		
		ReplyService svc= new ReplyServiceImpl();
		if(svc.addReply(rvo)){
//			System.out.println("등록성공");
//			resp.sendRedirect("main.do");
			result.put("retCode", "OK");
			result.put("retVal", rvo);
			
			//resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
			result.put("retCode", "NG");
			result.put("retVal", null);
			
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);
		
		resp.getWriter().print(json);
	}


	}


