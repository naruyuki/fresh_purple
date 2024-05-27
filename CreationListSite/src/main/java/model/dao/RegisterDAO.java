package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	public int registerUser(String user_id,String password,String name) {
	 int result=0;
	 String sql = "INSERT INTO m_users(user_id,password,name)VALUES(?,?,?)";
	 
	 try(Connection con = ConnectionManager.getConnection();
		 PreparedStatement pstmt = con.prepareStatement(sql)){
		 
		 pstmt.setString(1, user_id);
		 pstmt.setString(2, password);
		 pstmt.setString(3, name);
		 
		 
		 result =pstmt.executeUpdate();
			 
	}catch(SQLException e) {
		System.out.println("DBに接続できませんでした。");
		e.printStackTrace();
	}
	 return result;
	}

}
