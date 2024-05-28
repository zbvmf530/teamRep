package com.dosirak.common.vo;

import lombok.Data;

@Data
public class OrderDetailVO {
	private int detailNo, orderNo, productCode, optionCode, count, price;
	private String memberId;
}
