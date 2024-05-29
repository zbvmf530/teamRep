package com.dosirak.jsb.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dosirak.common.Control;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GetIDControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Map<String, String> sessionInfo = new HashMap<>();
		
		//System.out.println("logId = " + session.getAttribute("logId"));
		if(session.getAttribute("logId") == null) {
			session.setAttribute("logId", "none");
			if(session.getAttribute("auth") == null) {session.setAttribute("auth", "none");}
			}
		String logId = session.getAttribute("logId").toString();
		String auth = session.getAttribute("auth").toString();
		sessionInfo.put("logId", logId);
		sessionInfo.put("auth", auth);
			
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(sessionInfo);
			//System.out.println(json);
			resp.getWriter().print(json);
		}
	}


