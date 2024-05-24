package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;
import com.yedam.vo.TmemberVO;

public interface MemberMapper {

	
	int addMember(TmemberVO mem);
	int checkMember(String id);
	int tselectMember(@Param("id") String id, @Param("pw") String pw);
}
