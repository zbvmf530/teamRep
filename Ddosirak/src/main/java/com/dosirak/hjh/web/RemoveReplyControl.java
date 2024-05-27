package com.dosirak.hjh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.hjh.service.ReplyService;
import com.dosirak.hjh.service.ReplyServiceImpl;


public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String rno = req.getParameter("rno");
		ReplyService svc = new ReplyServiceImpl();
		// {"retCode":"Ok"}
		if (svc.removeReply(Integer.parseInt(rno))) {
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}

	}

}
