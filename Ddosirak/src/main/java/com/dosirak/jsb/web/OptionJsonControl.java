package com.dosirak.jsb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.common.Control;
import com.dosirak.common.vo.OptionVO;
import com.dosirak.jsb.service.OptionService;
import com.dosirak.jsb.service.OptionServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class OptionJsonControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OptionService svc = new OptionServiceImpl();
		OptionVO option = svc.getcartedOption(Integer.parseInt(req.getParameter("optionCode")));
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(option);
		resp.getWriter().print(json);
	}

}
