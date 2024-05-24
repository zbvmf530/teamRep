package com.ksh.mapper;

import org.apache.ibatis.annotations.Param;


import com.team.vo.TmemberVO;

public interface MemberMapper {

	
	int addMember(TmemberVO mem);
	int checkMember(String id);
	int tselectMember(@Param("id") String id, @Param("pw") String pw);
	TmemberVO getMember(String id);
}
