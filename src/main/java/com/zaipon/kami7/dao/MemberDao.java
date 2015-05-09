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
			int nowId = 0;
			while(rs.next()){
				nowId = rs.getInt("member_id");
				System.out.println("==== rs:nowID:"+nowId+"/lastId:"+lastId+"===");
				if(nowId != lastId){//次の人へ移った場合はリストに追加する
					memberDto = new MemberDto();
					memberDto.setMemberId(nowId);
					System.out.println("==== rs:memName:"+rs.getString("member_name")+"===");
					memberDto.setMemberName(rs.getString("member_name"));
					System.out.println("==== rs:image_path:"+rs.getString("image_path")+"===");
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
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
	}

	public void insert(String memberName){
		Connection con = null;
		ConnectionUtility connUtil = new ConnectionUtility();

		try {
			//con = createConnection();
			con = ConnectionUtility.getConnection();
			Integer id = this.getCount()+1;
			
			StringBuilder sb = new StringBuilder();
			sb.append("insert").append("\r\n");
			sb.append("into public.member ( member_id,member_name )").append("\r\n");
			sb.append("values ("+id+",'"+memberName+"');").append("\r\n");

			
			String sql = sb.toString();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

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
			};
		}
	}
	
	public ArrayList<MemberDto> searchAll(){
		Connection con = null;
		ConnectionUtility connUtil = new ConnectionUtility();
		
		try {
			//con = createConnection();
			con = ConnectionUtility.getConnection();
			System.out.println("==== getConnection  ===");
			
			StringBuilder sb = new StringBuilder();
			sb.append("select").append("\r\n");
			sb.append("member.member_id, member.member_name").append("\r\n");
			sb.append("from").append("\r\n");
			sb.append("member").append("\r\n");
			sb.append("order by member.member_id;").append("\r\n");
			
			String sql = sb.toString();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			ArrayList<MemberDto> memberDtoList = new ArrayList<MemberDto>();
			MemberDto memberDto;
			
			while(rs.next()){
				memberDto = new MemberDto();
				memberDto.setMemberId(rs.getInt("member_id"));
				memberDto.setMemberName(rs.getString("member_name"));
				memberDtoList.add(memberDto);
			}
			return memberDtoList;
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
			};
		}
	}

	public Integer getCount(){
		Connection con = null;
		ConnectionUtility connUtil = new ConnectionUtility();
		
		try {
			//con = createConnection();
			con = ConnectionUtility.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("select").append("\r\n");
			sb.append("count(*)").append("\r\n");
			sb.append("from").append("\r\n");
			sb.append("member;").append("\r\n");
			
			String sql = sb.toString();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			Integer cnt = 0;
			while(rs.next()){
				cnt = rs.getInt(1);
			}
			return cnt;
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
			};
		}
	}
}
