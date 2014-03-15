package com.zaipon.kami7.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	public Connection createConnection(){

		try {
			// JDBCドライバの登録
			String driver = "org.postgresql.Driver";
			// データベースの指定
			String server   = "kami7.herokuapp.com";   // PostgreSQL サーバ ( IP または ホスト名 )
			String dbname   = "postgres";         // データベース名
			String url = "jdbc:postgresql://kami7.herokuapp.com:5432/postgres";
			String user     = "nagany0209@gmail.com";         //データベース作成ユーザ名
			String password = "mina4799";     //データベース作成ユーザパスワード
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

	public void closeConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
