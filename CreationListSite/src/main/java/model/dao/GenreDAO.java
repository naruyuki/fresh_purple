package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Genre;

public class GenreDAO {
	
	public List<Genre> getGenreNames(){
		List<Genre> list = new ArrayList<>();
		
		String sql = "SELECT * FROM m_genre";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				
				Genre a = new Genre();
				
				a.setGenre_id(res.getInt("genre_id"));
				a.setGenre_name(res.getString("genre_name"));
				
				list.add(a);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
