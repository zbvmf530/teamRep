package com.dosirak.common.vo;

import lombok.Data;

@Data
public class CartVO {
	private int cartNo, productCode, optionCode, count, price;
}
