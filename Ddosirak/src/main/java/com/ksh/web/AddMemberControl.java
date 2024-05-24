package com.ksh.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.common.Control;

import com.ksh.service.MemberService;
import com.ksh.service.MemberServiceImpl;
import com.team.vo.TmemberVO;

public class AddMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		MemberService svc = new MemberServiceImpl();
		
		TmemberVO mvo= new TmemberVO();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String domain = req.getParameter("domain");
		String year = req.getParameter("birth-year");
		String month = req.getParameter("birth-month");
		String day = req.getParameter("birth-day");
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(domain);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);		
				
		String str = year+"-"+month+"-"+day;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
			Date date;
			try {
				date = format.parse(str);
				mvo.setBirthDate(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		mvo.setMemberId(id);
		mvo.setMemberPw(pw);
		mvo.setName(name);
		mvo.setPhoneNum(phone);
		mvo.setEmail(email+"@"+domain);
	
		if (svc.addMember(mvo)) {
			System.out.println("등록성공.");
			// 페이지이동 :목록페이지.
			resp.sendRedirect("main.do");

		} else {
			System.out.println("등록실패.");
			resp.sendRedirect("main.do");

		}
	}

}
