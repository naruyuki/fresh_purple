package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadDAO {
	
	public int uploadCreation(String title, String id, String text, int genre_id) {
    	int cnt = 0;
    	String sql = "INSERT INTO m_creation(creation_title, creation_text, date, user_id, genre_id) VALUES (?, ?, ?, ?,?)";
    	
    	Date nowDate = new Date();


        // 表示形式を指定
        SimpleDateFormat sdf1
        = new SimpleDateFormat("yyyy-MM-dd");
        String formatNowDate = sdf1.format(nowDate);

    	
    	try (Connection con = ConnectionManager.getConnection();
    			PreparedStatement pstmt = con.prepareStatement(sql)) {
    		
    		
    		pstmt.setString(1, title);
    		pstmt.setString(2, text);
    		pstmt.setString(3, formatNowDate);
    		pstmt.setString(4, id);
    		pstmt.setInt(5, genre_id);
    		
    		
    		cnt = pstmt.executeUpdate();
    			
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return cnt;
    }
	
	
	public int uploadRough(String rough_title, String rough_text, String user_id, int genre_id) {
		int cnt = 0;
		String sql = "INSERT INTO m_rough(rough_title, rough_text,date, user_id, genre_id) VALUES (?, ?, ?, ?,?)";
	   	Date nowDate = new Date();


        // 表示形式を指定
        SimpleDateFormat sdf1
        = new SimpleDateFormat("yyyy-MM-dd");
        String formatNowDate = sdf1.format(nowDate);

    	
    	try (Connection con = ConnectionManager.getConnection();
    			PreparedStatement pstmt = con.prepareStatement(sql)) {
    		
    		
    		pstmt.setString(1, rough_title);
    		pstmt.setString(2, rough_text);
    		pstmt.setString(3, formatNowDate);
    		pstmt.setString(4, user_id);
    		pstmt.setInt(5, genre_id);
    		
    		
    		cnt = pstmt.executeUpdate();
    			
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return cnt;
    }

}
