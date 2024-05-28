package com.dosirak.ksh.service;

import org.apache.ibatis.session.SqlSession;

import com.dosirak.common.DataSource;
import com.dosirak.common.vo.TmemberVO;
import com.dosirak.ksh.mapper.MemberMapper;

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


	@Override
	public TmemberVO getMember(String id) {
		// TODO Auto-generated method stub
		return mapper.getMember(id);
	}


	

}
