package com.team.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsb.web.MainControl;
import com.jsb.web.MypageControl;
import com.ksh.web.AddMemberControl;
import com.ksh.web.IdCheck;
import com.ksh.web.LogOutControl;
import com.ksh.web.SignupForm;
import com.ksh.web.tLoginControl;
import com.ksh.web.tLoginForm;






public class FrontControl extends HttpServlet{

Map<String, Control> map;
	
	// 생성자
	public FrontControl() {
		map = new HashMap<>();
	}
	// init
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 메인페이지
		map.put("/main.do", new MainControl());
		
		// 마이페이지
		map.put("/mypage.do", new MypageControl());
		
		// 로그인, 회원가입 관련 콘트롤
		map.put("/tloginForm.do", new tLoginForm());
		map.put("/tlogin.do", new tLoginControl());
		map.put("/signupform.do", new SignupForm());
		map.put("/signup.do", new AddMemberControl());
		map.put("/check.do", new IdCheck());
		map.put("/logout.do", new LogOutControl());
	}
	
	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// filter에서 이미 처리함
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println("uri : "+uri+", context : "+context);
		String path = uri.substring(context.length());
		System.out.println("path : "+path);
		
		Control control = map.get(path);
		control.exec(req,resp);
	}
	
	// destroy
	@Override
	public void destroy() {
		System.out.println("destroy 호출됨. :: 인스턴스가 메모리에 사라질 때 호출.");
	}
}
