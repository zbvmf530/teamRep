package com.jsb.service;

import java.util.List;

import com.dosirak.common.vo.OrderDetailVO;
import com.dosirak.common.vo.OrderVO;

public interface OrderDetailService {
	List<OrderDetailVO> getOrderDetail(OrderVO order);

}
