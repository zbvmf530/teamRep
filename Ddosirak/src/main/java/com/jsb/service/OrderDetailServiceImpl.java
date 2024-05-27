package com.jsb.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsb.mapper.OrderDetailMapper;
import com.team.common.DataSource;
import com.team.vo.OrderDetailVO;
import com.team.vo.OrderVO;

public class OrderDetailServiceImpl implements OrderDetailService{

	SqlSession session = DataSource.getInstance().openSession(true);
	OrderDetailMapper mapper = session.getMapper(OrderDetailMapper.class);
	@Override
	public List<OrderDetailVO> getOrderDetail(OrderVO order) {
		// TODO Auto-generated method stub
		return mapper.orderDetailList(order);
	}

}
