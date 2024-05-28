package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CreationList;

public class CreationDAO {
    
    public String LoginCertification(String user_id, String password) {
        String result = "";
        String sql = "SELECT * FROM m_users WHERE user_id = ? AND password = ?";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, user_id);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getString("name");
                }
            }
        } catch (SQLException e) {
            System.out.println("DB接続できませんでした。");
            e.printStackTrace();
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public List<CreationList> GetListForMonth() {
        List<CreationList> list = new ArrayList<>();
        String sql = "SELECT m_creation.creation_id, m_creation.creation_title, m_users.name, " +
                     "COUNT(m_creationfav.creationfav_id) AS review_count " +
                     "FROM m_creation " +
                     "INNER JOIN m_users ON m_creation.user_id = m_users.user_id " +
                     "LEFT JOIN m_creationfav ON m_creation.creation_id = m_creationfav.creation_id " +
                     "WHERE m_creation.date BETWEEN DATE_SUB(CURRENT_DATE, INTERVAL 30 DAY) AND CURRENT_DATE " +
                     "GROUP BY m_creation.creation_id, m_creation.creation_title, m_users.name " +
                     "ORDER BY review_count DESC;";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                CreationList creation = new CreationList();
                creation.setCreation_id(rs.getInt("creation_id"));
                creation.setCreation_title(rs.getString("creation_title"));
                creation.setName(rs.getString("name"));
                creation.setReview_count(rs.getInt("review_count"));
                list.add(creation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public CreationList GetCreation(String title) {
        CreationList cr = new CreationList();
        String sql = "SELECT m_creation.creation_title, m_creation.creation_text, " +
                     "COUNT(m_creationfav.creationfav_id) AS like_count, m_users.name AS author " +
                     "FROM m_creation " +
                     "INNER JOIN m_users ON m_creation.user_id = m_users.user_id " +
                     "LEFT JOIN m_creationfav ON m_creation.creation_id = m_creationfav.creation_id " +
                     "WHERE m_creation.creation_title = ? " +
                     "GROUP BY m_creation.creation_title, m_creation.creation_text, m_users.name;";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, title);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cr.setCreation_title(rs.getString("creation_title"));
                    cr.setCreation_text(rs.getString("creation_text"));
                    cr.setReview_count(rs.getInt("like_count"));
                    cr.setName(rs.getString("author"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cr;
    }
    
    
    
    
    
    
    
    
    
    
    

    public List<CreationList> GetComments(String creation_id) {
        List<CreationList> list = new ArrayList<>();
        String sql = "SELECT m_comment.comment_text, m_users.name AS comment_author, " +
                     "COUNT(m_commentfav.commentfav_id) AS like_count " +
                     "FROM m_comment " +
                     "INNER JOIN m_users ON m_comment.user_id = m_users.user_id " +
                     "LEFT JOIN m_commentfav ON m_comment.comment_id = m_commentfav.comment_id " +
                     "WHERE m_comment.creation_id = ? " +
                     "GROUP BY m_comment.comment_id, m_comment.comment_text, m_users.name;";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, creation_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CreationList comment = new CreationList();
                    comment.setComment_text(rs.getString("comment_text"));
                    comment.setName(rs.getString("comment_author"));
                    comment.setReview_count(rs.getInt("like_count"));
                    list.add(comment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public int LikeCreation(String user_id, String creation_id) {
        int ans = 0;
        String sql = "INSERT INTO m_creationfav (user_id, creation_id) VALUES (?, ?);";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, user_id);
            pstmt.setString(2, creation_id);
            ans = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    public int LikeComment(String user_id, String comment_id) {
        int ans = 0;
        String sql = "INSERT INTO m_commentfav (user_id, comment_id) VALUES (?, ?);";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, user_id);
            pstmt.setString(2, comment_id);
            ans = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean CheckLikeCreation(String user_id, String creation_id) {
        boolean ans = false;
        String sql = "SELECT * FROM m_creationfav WHERE user_id = ? AND creation_id = ?";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, user_id);
            pstmt.setString(2, creation_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ans = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public boolean CheckLikeComment(String user_id, String comment_id) {
        boolean ans = false;
        String sql = "SELECT * FROM m_commentfav WHERE user_id = ? AND comment_id = ?";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, user_id);
            pstmt.setString(2, comment_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ans = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }

    
    
    
    
    
    
    
    
    
    
    
    public int DisLikeCreation(String user_id, String creation_id) {
        int ans = 0;
        String sql = "DELETE FROM m_creationfav WHERE user_id = ? AND creation_id = ?";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, user_id);
            pstmt.setString(2, creation_id);
            ans = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }

    
    
    
    
    
    
    
    
    
    
    public List<CreationList> GetLikeCreations(String user_id) {
        List<CreationList> list = new ArrayList<>();
        String sql = "SELECT m_creation.creation_id AS novel_id, m_creation.creation_title AS novel_title, " +
                     "m_users.name AS author, COUNT(m_creationfav.creationfav_id) AS like_count " +
                     "FROM m_creation " +
                     "INNER JOIN m_users ON m_creation.user_id = m_users.user_id " +
                     "INNER JOIN m_creationfav AS user_fav ON m_creation.creation_id = user_fav.creation_id " +
                     "LEFT JOIN m_creationfav ON m_creation.creation_id = m_creationfav.creation_id " +
                     "WHERE user_fav.user_id = ? " +
                     "GROUP BY m_creation.creation_id, m_creation.creation_title, m_users.name " +
                     "ORDER BY like_count DESC;";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, user_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CreationList creation = new CreationList();
                    creation.setCreation_id(rs.getInt("novel_id"));
                    creation.setCreation_title(rs.getString("novel_title"));
                    creation.setName(rs.getString("author"));
                    creation.setReview_count(rs.getInt("like_count"));
                    list.add(creation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    
    
    
    
    
    
    
    
    

    public List<CreationList> GetMyCreations(String user_id) {
        List<CreationList> list = new ArrayList<>();
        String sql = "SELECT m_creation.creation_id AS novel_id, m_creation.creation_title AS novel_title, " +
                     "m_users.name AS author, COUNT(m_creationfav.creationfav_id) AS like_count " +
                     "FROM m_creation " +
                     "INNER JOIN m_users ON m_creation.user_id = m_users.user_id " +
                     "LEFT JOIN m_creationfav ON m_creation.creation_id = m_creationfav.creation_id " +
                     "WHERE m_creation.user_id = ? " +
                     "GROUP BY m_creation.creation_id, m_creation.creation_title, m_users.name " +
                     "ORDER BY like_count DESC;";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, user_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CreationList creation = new CreationList();
                    creation.setCreation_id(rs.getInt("novel_id"));
                    creation.setCreation_title(rs.getString("novel_title"));
                    creation.setName(rs.getString("author"));
                    creation.setReview_count(rs.getInt("like_count"));
                    list.add(creation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    //検索結果一覧表示
    
    public List<CreationList> searchingFor(String search) {
        List<CreationList> list = new ArrayList<>();
        
        String sql = "SELECT\n"
                + "    m_creation.creation_id,\n"
                + "    m_creation.creation_title,\n"
                + "    m_users.name AS author,\n"
                + "    COUNT(m_creationfav.creationfav_id) AS like_count\n"
                + "FROM\n"
                + "    m_creation\n"
                + "INNER JOIN\n"
                + "    m_users ON m_creation.user_id = m_users.user_id\n"
                + "LEFT JOIN\n"
                + "    m_creationfav ON m_creation.creation_id = m_creationfav.creation_id\n"
                + "WHERE\n"
                + "    m_users.name LIKE ?\n"
                + "GROUP BY\n"
                + "    m_creation.creation_id,\n"
                + "    m_creation.creation_title,\n"
                + "    m_users.name\n"
                + "ORDER BY\n"
                + "    like_count DESC;\n";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
        	
            // プレースホルダーに値をセットする
            pstmt.setString(1, "%" + search + "%");

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                CreationList a = new CreationList();
                a.setCreation_id(res.getInt("creation_id"));
                a.setCreation_title(res.getString("creation_title"));
                a.setName(res.getString("author"));
                a.setReview_count(res.getInt("like_count"));

                list.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    
    
    
    public int updateName(String user_id, String name) {
    	String sql = "UPDATE m_users SET name = ? WHERE user_id = ?";
    	int cnt = 0;
    	try (Connection con = ConnectionManager.getConnection();
    			PreparedStatement pstmt = con.prepareStatement(sql)) {
    		pstmt.setString(1, name);
    		pstmt.setString(2, user_id);
    		cnt = pstmt.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return cnt;
    }
    
    
    
    
    
	public int uploadRough(String title, String text, String id, int genre_id) throws ClassNotFoundException {
		int cnt = 0;
		String sql = "INSERT INTO m_creation(creation_title, creation_text, user_id, genre_id) VALUES (?, ?, ?, ?)";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setString(2, text);
			pstmt.setString(3, id);
			pstmt.setInt(4, genre_id);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	
	
	public int deleteRough(int rough_id) throws ClassNotFoundException {
		int cnt = 0;
		String sql = "DELETE FROM m_creation WHERE rough_id = ?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, rough_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	
	
	public int uploadRoughIntoCreation() throws ClassNotFoundException {
		int cnt = 0;
		String sql = "";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

    
    //コメント投稿
    
    public int uploadComment(String user_id,String comment,int creation_id) {
    	int res = 0;
    	
    	String sql ="INSERT INTO m_comment (comment_text,user_id,creation_id)VALUES(?,?,?)";
    	
    	try(Connection con = ConnectionManager.getConnection();
    			PreparedStatement pstmt = con.prepareStatement(sql)){
    		
    		pstmt.setString(1, comment);
    		pstmt.setString(2, user_id);
    		pstmt.setInt(3, creation_id);
    		
    		res = pstmt.executeUpdate();
    		
    		
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return res;
    	
    }
    
    
    
>>>>>>> branch 'main' of https://github.com/naruyuki/fresh_purple.git
    
    
    
    
    
//    public int uploadCreation(String title, String id, String text, int genre_id) {
//    	int cnt = 0;
//    	String sql = "INSERT INTO m_creation(creation_title, creation_text, date, ) VALUES (?, ?, ?, ?)";
//    	
//    	try (Connection con = ConnectionManager.getConnection();
//    			PreparedStatement pstmt = con.prepareStatement(sql)) {
//    		pstmt.setString(1, title);
//    		pstmt.setString(2, id);
//    		pstmt.setString(3, text);
//    		pstmt.setInt(4, genre_id);
//    		cnt = pstmt.executeUpdate();
//    			
//    		
//    	} catch (SQLException e) {
//    		e.printStackTrace();
//    	}
//    	return cnt;
//    }
//    
//    
    
    
    
}
