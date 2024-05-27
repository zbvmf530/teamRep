package com.dosirak.common.vo;

import lombok.Data;

@Data
public class OrderVO {
	private int orderNo, totalPrice;
	private String memberId, orderDate, orderStatus, deliveryAddress;
}
