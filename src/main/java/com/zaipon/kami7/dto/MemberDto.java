package com.zaipon.kami7.dto;

import java.util.ArrayList;

public class MemberDto {
	private Integer memberId;
	private String memberName;
	private ArrayList<String> imgPaths;
	
	public MemberDto() {
		this.imgPaths = new ArrayList<String>();
	}
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public ArrayList<String> getImgPaths() {
		return imgPaths;
	}
	public void setImgPaths(ArrayList<String> imgPaths) {
		this.imgPaths = imgPaths;
	}
	
	
}
