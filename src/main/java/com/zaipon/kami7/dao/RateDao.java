package com.zaipon.kami7.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaipon.kami7.dto.RateDto;


public class RateDao {

	
	public RateDto find(Integer categoryId, Integer memberId){
		Connection con = null;
		ConnectionUtility connUtil = new ConnectionUtility();
		
		try {
			con = connUtil.createConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("select").append("\r\n");
			sb.append("rate.category_id, rate.member_id, rate.rate").append("\r\n");
			sb.append("from").append("\r\n");
			sb.append("rate").append("\r\n");
			sb.append("where").append("\r\n");
			sb.append("rate.category_id = "+ categoryId +" and").append("\r\n");//
			sb.append("rate.member_id = "+ memberId +" and").append("\r\n");//
			sb.append("rate.delete_flag = false").append("\r\n");

			String sql = sb.toString();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			RateDto rateDto = new RateDto();

			while(rs.next()){
				rateDto.setCategoryId(rs.getInt("category_id"));
				rateDto.setMemberId(rs.getInt("member_id"));
				rateDto.setRate(rs.getInt("rate"));
			}
			return rateDto;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		} finally {
			connUtil.closeConnection(con);
		}
	}
	
	public void update(Integer categoryId, Integer memberId, Integer newRate){
		Connection con = null;
		ConnectionUtility connUtil = new ConnectionUtility();
		
		try {
			con = connUtil.createConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("update").append("\r\n");
			sb.append("rate").append("\r\n");
			sb.append("set").append("\r\n");
			sb.append("rate = " + newRate).append("\r\n");
			sb.append("where").append("\r\n");
			sb.append("rate.category_id = "+  categoryId+" and").append("\r\n");
			sb.append("rate.member_id = "+ memberId +" and").append("\r\n");
			sb.append("rate.delete_flag = false").append("\r\n");
			
			String sql = sb.toString();
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			connUtil.closeConnection(con);
		}
	}
}