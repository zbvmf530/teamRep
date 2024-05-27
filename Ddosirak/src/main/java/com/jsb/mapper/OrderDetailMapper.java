package com.jsb.mapper;

import java.util.List;

import com.team.vo.OrderDetailVO;
import com.team.vo.OrderVO;

public interface OrderDetailMapper {
	List<OrderDetailVO> orderDetailList(OrderVO order);
}
