package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditDAO {
	
	public int editCreation(int creation_id,String title,String text,int genre_id) {
		int res = 0;
		
		String sql = "UPDATE m_creation SET creation_title = ?,creation_text = ?,genre_id = ? WHERE creation_id = ?";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, title);
			pstmt.setString(2, text);
			pstmt.setInt(3, genre_id);
			pstmt.setInt(4, creation_id);
			
			res = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return res;
		
	}
	
	public int deleteCreation(int creation_id) {
		int res = 0;
		
		String sql = "DELETE FROM m_creation WHERE creation_id = ?";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			

			pstmt.setInt(1, creation_id);
			
			res = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return res;
		
	}

}
