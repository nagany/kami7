package com.zaipon.kami7.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zaipon.kami7.dao.MemberDao;
import com.zaipon.kami7.dao.impl.MockMemberDao;
import com.zaipon.kami7.dao.impl.MockRateDao;
import com.zaipon.kami7.dto.MemberDto;
import com.zaipon.kami7.dto.RateDto;
import com.zaipon.kami7.service.command.MatchResultCommand;
import com.zaipon.kami7.service.form.MemberForm;

public class MemberBusiness {
	//カテゴリIDをもとに、あるカテゴリにエントリーしてるメンバーの一覧を取得する.
	//return: List<MemberDto>

	MemberDao memberDao;
	MockRateDao rateDao;
	
	public MemberBusiness() {
		this.memberDao = new MemberDao();
		this.rateDao = new MockRateDao();
	}
	
	public List<MemberForm> getEntry(Integer categoryId){
		System.out.println("=========================");
		System.out.println("memberbusiness/getEntry isCalled.  categoryId="+categoryId);
		System.out.println("=========================");
		ArrayList<MemberDto> dtoList =	this.memberDao.searchEntry(categoryId);
		
		MemberForm form;
		int randIndex;
		List<MemberForm> resultList = new ArrayList<MemberForm>();
		for(MemberDto dto: dtoList){
			form = new MemberForm();
			form.setMemberId(dto.getMemberId().toString());
			form.setMemberName(dto.getMemberName());
			
			List<String> list = dto.getImgPaths();
			randIndex = (int)(Math.random()*list.size());
			
			form.setImgPath(list.get(randIndex));
			
			resultList.add(form);
		}
		return resultList;
	}
	
	public HashSet<MemberForm> getPair(Integer categoryId){
		System.out.println("=========================");
		System.out.println("memberbusiness/getPair isCalled.  categoryId="+categoryId);
		System.out.println("=========================");
		List<MemberForm> list = this.getEntry(categoryId);
		HashSet<MemberForm> pair = new HashSet<MemberForm>();
		int randIndex;
		while(pair.size() != 2){
			randIndex = (int)(Math.random()*list.size());
			System.out.println(randIndex);
			pair.add(list.get(randIndex));
		}
		return pair;
	}
	
	public void updateRate(MatchResultCommand command){
		RateDto winnerRate = this.rateDao.find(command.getCategoryId(),command.getWinnerId());
		RateDto loserRate = this.rateDao.find(command.getCategoryId(),command.getLoserId());
		
		int value = this.eloRating(winnerRate.getRate(), loserRate.getRate());
		
		this.rateDao.update(command.getCategoryId(),command.getWinnerId(),winnerRate.getRate()+value);
		this.rateDao.update(command.getCategoryId(),command.getWinnerId(),winnerRate.getRate()-value);
		
		System.out.println(winnerRate.getRate()+value);
		System.out.println(loserRate.getRate()-value);
		
	}
		
	private Integer eloRating(Integer winnerRate, Integer loserRate){
		double value = 16 + (loserRate - winnerRate) * 0.04;
		System.out.println(value);
		
		if(value < 1){
			return 1;
		}else if (value > 31) {
			return 31;
		}else{
			return (int) Math.round(value);
		}
	}
}
