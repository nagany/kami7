package com.zaipon.kami7.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zaipon.kami7.dto.MemberDto;



public class MemberDao {

	public MemberDao(){

	}

	public ArrayList<MemberDto> searchEntry(Integer categoryId){
		Connection con = null;
		ConnectionUtility connUtil = new ConnectionUtility();
		
		try {
			//con = createConnection();
			con = ConnectionUtility.getConnection();
			System.out.println("==== getConnection  ===");
			
			StringBuilder sb = new StringBuilder();
			sb.append("select").append("\r\n");
			sb.append("rate.member_id, member.member_name, member_image.image_path, rate.rate").append("\r\n");
			sb.append("from").append("\r\n");
			sb.append("member, rate, member_image").append("\r\n");
			sb.append("where").append("\r\n");
			sb.append("rate.member_id = member.member_id and").append("\r\n");
			sb.append("member.member_id = member_image.member_id and").append("\r\n");
			sb.append("rate.category_id = "+ categoryId +" and").append("\r\n");//
			sb.append("rate.delete_flag = false").append("\r\n");
			sb.append("order by rate.member_id;").append("\r\n");

			
			String sql = sb.toString();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("==== executeSQL  rs:"+rs+" ===");

			ArrayList<MemberDto> memberDtoList = new ArrayList<MemberDto>();
			MemberDto memberDto;

			System.out.println("==== prepare  memdtolist:"+memberDtoList+" ===");

			int lastId = 0;
			while(rs.next()){
				int nowId = rs.getInt("member_id");
				if(nowId != lastId){//次の人へ移った場合はリストに追加する
					memberDto = new MemberDto();
					memberDto.setMemberId(nowId);
					memberDto.setMemberName(rs.getString("member_name"));
					memberDto.getImgPaths().add(rs.getString("image_path"));
					memberDtoList.add(memberDto);
					lastId = nowId;
				}else{//同じ人の場合は画像パスをaddするだけ
					memberDtoList.get(memberDtoList.size()-1).getImgPaths().add(rs.getString("image_path"));
				}
			}
			System.out.println("==== return memDtoList  ===");
			
			return memberDtoList;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("==== SQL Exception  ===");
			return null;
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("==== Exception  ==="+ e.toString());
			return null;
		} finally {
			connUtil.closeConnection(con);
		}
	}


}
