package com.dosirak.common.vo;

import lombok.Data;

@Data
public class ProductOptionVO {
	private int optionCode;
	private int productCode;
	private String optionName;
	private int optionPrice;
}
