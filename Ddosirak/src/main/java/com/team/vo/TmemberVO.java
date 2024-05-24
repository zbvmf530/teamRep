package com.team.vo;

import java.util.Date;

import lombok.Data;

@Data
public class TmemberVO {

	private String memberId;
	private String memberPw;
	private String name;
	private String phoneNum;
	private String email;
	private Date birthDate;
	private String authority;
	
}
