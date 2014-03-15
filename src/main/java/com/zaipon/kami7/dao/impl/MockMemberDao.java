package com.zaipon.kami7.dao.impl;

import java.util.ArrayList;

import com.zaipon.kami7.dao.MemberDao;
import com.zaipon.kami7.dto.MemberDto;

public class MockMemberDao{

	public ArrayList<MemberDto> searchEntry(Integer categoryId) {
		MemberDto dto;
		ArrayList<String> paths = new ArrayList<String>();
		paths.add("笑顔.jpg");
		paths.add("変顔.jpg");
		paths.add("ドヤ顔.jpg");
		
		ArrayList<MemberDto> resultList = new ArrayList<MemberDto>();
		
		for(int i=0;i<10;i++){
			dto = new MemberDto();
			dto.setMemberId(i);
			dto.setImgPaths(paths);
			resultList.add(dto);
		}
		
		resultList.get(0).setMemberName("ぽん");
		resultList.get(1).setMemberName("ざいつ");
		resultList.get(2).setMemberName("ししど");
		resultList.get(3).setMemberName("へいし");
		resultList.get(4).setMemberName("わたる");
		resultList.get(5).setMemberName("ゆうちゃん");
		resultList.get(6).setMemberName("５");
		resultList.get(7).setMemberName("けいぞう");
		resultList.get(8).setMemberName("みよ");
		resultList.get(9).setMemberName("かやした");

		
		return resultList;
	}

}
