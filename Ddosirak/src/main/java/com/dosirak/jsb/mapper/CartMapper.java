package com.dosirak.jsb.mapper;

import java.util.List;

import com.dosirak.common.vo.CartVO;

public interface CartMapper {
	List<CartVO> cartList();
	int updateCart(CartVO cvo);
}
