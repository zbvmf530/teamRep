package com.dosirak.jsb.mapper;

import java.util.List;

import com.dosirak.common.vo.OptionVO;

public interface OptionMapper {
	List<OptionVO> optionList(int productCode);
	OptionVO getCartedoption(int optionCode);
}
