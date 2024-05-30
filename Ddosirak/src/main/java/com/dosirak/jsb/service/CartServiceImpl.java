package com.dosirak.jsb.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dosirak.common.DataSource;
import com.dosirak.common.vo.CartVO;
import com.dosirak.jsb.mapper.CartMapper;

public class CartServiceImpl implements CartService{
	SqlSession session = DataSource.getInstance().openSession(true);
	CartMapper mapper = session.getMapper(CartMapper.class);
	@Override
	public List<CartVO> cartList() {
		// TODO Auto-generated method stub
		return mapper.cartList();
	}
	@Override
	public boolean updateCart(CartVO cvo) {
		// TODO Auto-generated method stub
		return mapper.updateCart(cvo) == 1;
	}

}
