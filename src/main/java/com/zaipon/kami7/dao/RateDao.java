package com.zaipon.kami7.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zaipon.kami7.dto.RateDto;




public class RateDao {


	public RateDto find(Integer categoryId, Integer memberId){
		Connection con = null;
		ConnectionUtility connUtil = new ConnectionUtility();

		try {
			con = ConnectionUtility.getConnection();

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
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update(Integer categoryId, Integer memberId, Integer newRate){
		Connection con = null;
		ConnectionUtility connUtil = new ConnectionUtility();

		try {
			con = ConnectionUtility.getConnection();

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
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<RateDto> findByCategoryId(Integer categoryId){
		ArrayList<RateDto> sortedData = new ArrayList<RateDto>();

		Connection con = null;

		//ここなおす
		try {
			con = ConnectionUtility.getConnection();

			StringBuilder sb = new StringBuilder();
			sb.append("select").append("\r\n");
			sb.append("rate.category_id, rate.member_id, rate.rate, member.member_name, category.category_name").append("\r\n");
			sb.append("from rate").append("\r\n");
			sb.append("inner join member on rate.member_id = member.member_id").append("\r\n");
			sb.append("inner join category on rate.category_id = category.category_id").append("\r\n");
			sb.append("where").append("\r\n");
			sb.append("rate.category_id = "+ categoryId +" and").append("\r\n");
			sb.append("rate.delete_flag = false").append("\r\n");
			sb.append("order by rate.rate desc").append("\r\n");

			String sql = sb.toString();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			RateDto rateDto = null;

			while(rs.next()){
				rateDto = new RateDto();
				rateDto.setCategoryId(rs.getInt("category_id"));
				rateDto.setMemberId(rs.getInt("member_id"));
				rateDto.setRate(rs.getInt("rate"));
				rateDto.setMemberName(rs.getString("member_name"));
				rateDto.setCategoryName(rs.getString("category_name"));
				sortedData.add(rateDto);
			}
			return sortedData;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
