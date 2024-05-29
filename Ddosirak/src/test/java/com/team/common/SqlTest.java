package com.team.common;

import com.dosirak.jsb.service.OptionService;
import com.dosirak.jsb.service.OptionServiceImpl;

public class SqlTest {
	public static void main(String[] args) {

//		MemberService msvc = new MemberServiceImpl();
//		System.out.println(msvc.getMember("jsb0820"));

		OptionService svc = new OptionServiceImpl();
		
		svc.getoptionList(22).forEach(item->{System.out.println(item);});

	}
}
