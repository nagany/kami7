package com.zaipon.kami7.dao.impl;

import com.zaipon.kami7.dto.RateDto;

public class MockRateDao {

	public RateDto find(Integer categoryId, Integer memberId){
		RateDto dto = new RateDto();

		dto.setCategoryId(categoryId);
		dto.setMemberId(memberId);
		
		if(memberId == 1){
			dto.setRate(1600);
		}else{
			dto.setRate(1400);
		}
		return dto;
	}

	public void update(Integer categoryId, Integer memberId, Integer newRate) {
		//DB更新
	}
}
