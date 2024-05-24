package com.ksh.service;

import com.team.vo.TmemberVO;

public interface MemberService {
	boolean addMember(TmemberVO member);
	boolean chekId(String id);
	boolean login(String id, String pw);
	
	// 로그인한 회원 정보 가져오는 메소드
	TmemberVO getMember(String id);
	
}
