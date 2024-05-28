package com.dosirak.common.vo;

import java.util.Date;

import lombok.Data;
@Data
public class ReviewVO {
	private int reviewNo;
	private String memberId;
	private String reviewTitle;
	private String reviewContent;
	private int grade;
	private int productCode;
	private int gradeAvg;
	private int reviewCnt;
}
