package com.dosirak.jsb.mapper;

import java.util.List;

import com.dosirak.common.vo.OrderDetailVO;
import com.dosirak.common.vo.OrderVO;

public interface OrderDetailMapper {
	List<OrderDetailVO> orderDetailList(OrderVO order);
}
