package com.dosirak.jsb.service;

import java.util.List;

import com.dosirak.common.vo.CartVO;

public interface CartService {
	List<CartVO> cartList();
	boolean updateCart(CartVO cvo);
}
