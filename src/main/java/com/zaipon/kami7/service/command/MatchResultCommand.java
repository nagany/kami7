package com.zaipon.kami7.service.command;

public class MatchResultCommand {
	private Integer winnerId;
	private Integer loserId;
	private Integer categoryId;
	
	public Integer getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(Integer winnerId) {
		this.winnerId = winnerId;
	}
	public Integer getLoserId() {
		return loserId;
	}
	public void setLoserId(Integer loserId) {
		this.loserId = loserId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
