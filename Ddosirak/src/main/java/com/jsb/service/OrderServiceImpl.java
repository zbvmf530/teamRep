package com.jsb.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsb.mapper.OrderMapper;
import com.team.common.DataSource;
import com.team.vo.OrderVO;

public class OrderServiceImpl implements OrderService{

	SqlSession session = DataSource.getInstance().openSession(true);
	OrderMapper mapper = session.getMapper(OrderMapper.class);
	@Override
	public List<OrderVO> getOrderList(String id) {
		// TODO Auto-generated method stub
		return mapper.orderList(id);
	}

}
