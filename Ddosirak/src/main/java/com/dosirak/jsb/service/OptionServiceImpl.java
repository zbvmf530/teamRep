package com.dosirak.jsb.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dosirak.common.DataSource;
import com.dosirak.common.vo.OptionVO;
import com.dosirak.jsb.mapper.OptionMapper;

public class OptionServiceImpl implements OptionService{

	SqlSession session = DataSource.getInstance().openSession(true);
	OptionMapper mapper = session.getMapper(OptionMapper.class);
	@Override
	public List<OptionVO> getoptionList(int productCode) {
		// TODO Auto-generated method stub
		return mapper.optionList(productCode);
	}
	@Override
	public OptionVO getcartedOption(int optionCode) {
		// TODO Auto-generated method stub
		return mapper.getCartedoption(optionCode);
	}
}
