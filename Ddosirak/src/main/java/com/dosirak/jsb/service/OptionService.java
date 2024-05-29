package com.dosirak.jsb.service;

import java.util.List;

import com.dosirak.common.vo.OptionVO;

public interface OptionService {
	List<OptionVO> getoptionList(int productCode);
	OptionVO getcartedOption(int optionCode);
}
