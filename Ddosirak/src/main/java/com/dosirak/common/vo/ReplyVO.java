package com.dosirak.common.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int replyNo;	//댓글번호
	private int boardNo; 	//글번호
	private String memberId; //댓작성자
	private String replyContent;//댓내용
	
	private Date replyDate;	//작성일자
	private int replyCnt;

	
}
