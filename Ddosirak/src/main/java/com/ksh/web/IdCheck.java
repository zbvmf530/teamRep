package com.ksh.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ksh.service.MemberService;
import com.ksh.service.MemberServiceImpl;
public class IdCheck implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Map<String, Object> result = new HashMap<>();
		resp.setContentType("text/json;charset=utf-8");
		
		MemberService svc = new MemberServiceImpl();
		String id = req.getParameter("id");
		boolean chek = svc.chekId(id);
		
		if(chek) {
			result.put("check", "NO");
		}
		else {
			result.put("check", "OK");
		
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);
		resp.getWriter().print(json);
	}

}
