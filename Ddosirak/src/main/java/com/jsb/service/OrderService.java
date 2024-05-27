package com.jsb.service;

import java.util.List;

import com.dosirak.common.vo.OrderVO;

public interface OrderService {
	List<OrderVO> getOrderList(String id);
}
