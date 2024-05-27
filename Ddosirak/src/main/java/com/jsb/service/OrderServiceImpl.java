package com.jsb.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dosirak.common.DataSource;
import com.dosirak.common.vo.OrderVO;
import com.jsb.mapper.OrderMapper;

public class OrderServiceImpl implements OrderService{

	SqlSession session = DataSource.getInstance().openSession(true);
	OrderMapper mapper = session.getMapper(OrderMapper.class);
	@Override
	public List<OrderVO> getOrderList(String id) {
		// TODO Auto-generated method stub
		return mapper.orderList(id);
	}

}
