package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;
import com.yedam.vo.TmemberVO;

public class MemberServiceImpl implements MemberService {

	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	
	@Override
	public boolean addMember(TmemberVO member) {
		// TODO Auto-generated method stub
		System.out.println("등록성공.");
		return mapper.addMember(member) == 1;
	}


	@Override
	public boolean chekId(String id) {
		// TODO Auto-generated method stub
		if(mapper.checkMember(id)>0) {
			
			return true;
		}
		else{
			return false;
			
		}
	}


	@Override
	public boolean login(String id, String pw) {
		// TODO Auto-generated method stub
		return mapper.tselectMember(id, pw)==1;
	}


	

}
