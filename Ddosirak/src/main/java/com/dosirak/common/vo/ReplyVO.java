package com.dosirak.common.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int replyNo;
	private int boardNo; 
	private String memberId; 
	private String replyContent;
	
	private Date replyDate;

	
}
