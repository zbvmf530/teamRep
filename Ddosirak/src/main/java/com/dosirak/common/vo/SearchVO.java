package com.dosirak.common.vo;

import lombok.Data;

@Data
public class SearchVO {

	private String boardType; // 공지사항(N)/ 문의(Q)
	private int page;
	private String searchCondition;
	private String keyword;
	
	
	//댓글목록관련
	private int boardNo;
	private int rpage;
}
