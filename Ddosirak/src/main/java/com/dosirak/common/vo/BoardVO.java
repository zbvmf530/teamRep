package com.dosirak.common.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	private int boardNo; // board_no
	private String memberId;
	private int prodCode;
	private String category;
	private String boardTitle;
	private String boardContent;

	private Date boardDate;
	private String boardPw;
	private int boardViews;
	private int replyCnt;
}