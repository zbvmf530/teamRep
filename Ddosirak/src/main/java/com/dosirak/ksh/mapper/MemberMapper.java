package com.dosirak.ksh.mapper;

import org.apache.ibatis.annotations.Param;

import com.dosirak.common.vo.TmemberVO;

public interface MemberMapper {

	
	int addMember(TmemberVO member);
	int checkMember(String id);
	int tselectMember(@Param("id") String id, @Param("pw") String pw);
	TmemberVO getMember(String id);
}
