package com.yedam.service;

import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;
import com.yedam.vo.TmemberVO;

public interface MemberService {
	boolean addMember(TmemberVO member);
	boolean chekId(String id);
	boolean login(String id, String pw);
	
}
