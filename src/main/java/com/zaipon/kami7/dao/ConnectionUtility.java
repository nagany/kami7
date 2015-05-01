package com.zaipon.kami7.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	public static Connection getConnection() throws URISyntaxException, SQLException {
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();


		System.out.println("=========================");
		System.out.println("conUtil/getConnection isCalled.");
		System.out.println("dbUrl:"+dbUrl);
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println(DriverManager.getConnection(dbUrl, username, password));
		System.out.println("=========================");
	    
	    return DriverManager.getConnection(dbUrl, username, password);
	}

	/*
	public Connection createConnection(){

		try {
			// JDBCドライバの登録
			String driver = "org.postgresql.Driver";
			// データベースの指定
			String server   = "ec2-54-225-101-119.compute-1.amazonaws.com";   // PostgreSQL サーバ ( IP または ホスト名 )
			String dbname   = "dbc285t3b5t1rl";         // データベース名
			String url = "jdbc:postgresql://ec2-54-225-101-119.compute-1.amazonaws.com:5432/dbc285t3b5t1rl";
			String user     = "pxveoglutvfuzz";         //データベース作成ユーザ名
			String password = "RsaIdqg7MXJmOMsXP3LwOxgsTt";     //データベース作成ユーザパスワード
			Class.forName (driver);
			// データベースとの接続
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			System.err.println("SQL failed.");
			e.printStackTrace ();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace ();
		}
		return null;
	}	
	*/

	public void closeConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
