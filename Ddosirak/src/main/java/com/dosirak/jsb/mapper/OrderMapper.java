package com.dosirak.jsb.mapper;

import java.util.List;

import com.dosirak.common.vo.OrderVO;

public interface OrderMapper {
	List<OrderVO> orderList(String id);
}
