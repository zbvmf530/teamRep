package com.jsb.service;

import java.util.List;

import com.team.vo.OrderDetailVO;
import com.team.vo.OrderVO;

public interface OrderDetailService {
	List<OrderDetailVO> getOrderDetail(OrderVO order);

}
