package com.dosirak.jsb.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dosirak.common.DataSource;
import com.dosirak.common.vo.OrderDetailVO;
import com.dosirak.common.vo.OrderVO;
import com.dosirak.jsb.mapper.OrderDetailMapper;

public class OrderDetailServiceImpl implements OrderDetailService{

	SqlSession session = DataSource.getInstance().openSession(true);
	OrderDetailMapper mapper = session.getMapper(OrderDetailMapper.class);
	@Override
	public List<OrderDetailVO> getOrderDetail(OrderVO order) {
		// TODO Auto-generated method stub
		return mapper.orderDetailList(order);
	}

}
