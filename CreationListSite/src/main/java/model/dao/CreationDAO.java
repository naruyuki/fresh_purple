/*     */ package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;

/*     */ import model.entity.CreationList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CreationDAO
/*     */ {
/*     */    public String LoginCertification(String user_id, String password) {
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<CreationList> GetListForMonth() {
/*  64 */     List<CreationList> list = new ArrayList<>();
/*     */ 
/*     */     
/*  67 */     String sql = "SELECT \n    m_creation.creation_id,\n    m_creation.creation_title,\n    m_users.name,\n    COUNT(m_creationfav.creationfav_id) AS review_count\nFROM \n    m_creation\nINNER JOIN \n    m_users ON m_creation.user_id = m_users.user_id\nLEFT JOIN \n    m_creationfav ON m_creation.creation_id = m_creationfav.creation_id\nWHERE\n    m_creation.date BETWEEN DATE_SUB(CURRENT_DATE, INTERVAL 7 DAY) AND CURRENT_DATE\nGROUP BY \n    m_creation.creation_id, m_creation.creation_title, m_users.name\nORDER BY \n    review_count DESC;";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  86 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 105 */     catch (SQLException e) {
/* 106 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CreationList GetCreation(String title) {
/* 123 */     CreationList cr = new CreationList();
/*     */     
/* 125 */     String sql = "SELECT \n    m_creation.creation_title,\n    m_creation.creation_text,\n    COUNT(m_creationfav.creationfav_id) AS like_count,\n    m_users.name AS author\nFROM \n    m_creation\nINNER JOIN \n    m_users ON m_creation.user_id = m_users.user_id\nLEFT JOIN \n    m_creationfav ON m_creation.creation_id = m_creationfav.creation_id\nWHERE \n    m_creation.creation_title = ? \nGROUP BY \n    m_creation.creation_title, m_creation.creation_text, m_users.name;\n";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 142 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 156 */     catch (SQLException e) {
/* 157 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */     
/* 161 */     return cr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<CreationList> GetCommnets(String creation_id) {
/* 169 */     List<CreationList> list = new ArrayList<>();
/*     */     
/* 171 */     String sql = "SELECT \n    m_comment.comment_text,\n    m_users.name AS comment_author,\n    COUNT(m_commentfav.commentfav_id) AS like_count\nFROM \n    m_comment\nINNER JOIN \n    m_users ON m_comment.user_id = m_users.user_id\nLEFT JOIN \n    m_commentfav ON m_comment.comment_id = m_commentfav.comment_id\nWHERE \n    m_comment.creation_id = ? GROUP BY \n    m_comment.comment_id, m_comment.comment_text, m_users.name;\n";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 187 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 208 */     catch (SQLException e) {
/* 209 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 214 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int LikeCreation(String user_id, String creation_id) {
/* 223 */     int ans = 0;
/*     */     
/* 225 */     String sql = "INSERT INTO m_creationfav (user_id,creation_id)VALUES(?,?);";
/*     */     
/*     */     try {
/* 228 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 236 */     catch (SQLException e) {
/* 237 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 243 */     return ans;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int LikeComment(String user_id, String comment_id) {
/* 252 */     int ans = 0;
/*     */     
/* 254 */     String sql = "INSERT INTO m_commentfav (user_id,comment_id)VALUES(?,?);";
/*     */     
/*     */     try {
/* 257 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 265 */     catch (SQLException e) {
/* 266 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 272 */     return ans;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean CheckLikeCreation(String user_id, String creation_id) {
/* 280 */     boolean ans = false;
/*     */     
/* 282 */     String sql = "SELECT * FROM m_creationfav WHERE user_id = ?";
/*     */     
/*     */     try {
/* 285 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 302 */     catch (SQLException e) {
/* 303 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 312 */     return ans;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean CheckLikeComment(String user_id, String comment_id) {
/* 319 */     boolean ans = false;
/*     */     
/* 321 */     String sql = "SELECT * FROM m_commentfav WHERE user_id = ?";
/*     */     
/*     */     try {
/* 324 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 341 */     catch (SQLException e) {
/* 342 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 351 */     return ans;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int DisLikeCreation(String user_id, String creation_id) {
/* 359 */     int ans = 0;
/*     */     
/* 361 */     String sql = "DELETE FROM m_creationfav WHERE user_id = ? AND creation_id = ?";
/*     */     
/*     */     try {
/* 364 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 374 */     catch (SQLException e) {
/* 375 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 381 */     return ans;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<CreationList> GetLikeCreations(String user_id) {
/* 390 */     List<CreationList> list = new ArrayList<>();
/*     */     
/* 392 */     String sql = "SELECT\n    m_creation.creation_id AS novel_id,\n    m_creation.creation_title AS novel_title,\n    m_users.name AS author,\n    COUNT(m_creationfav.creationfav_id) AS like_count\nFROM\n    m_creation\nINNER JOIN\n    m_users ON m_creation.user_id = m_users.user_id\nINNER JOIN\n    m_creationfav AS user_fav ON m_creation.creation_id = user_fav.creation_id\nLEFT JOIN\n    m_creationfav ON m_creation.creation_id = m_creationfav.creation_id\nWHERE\n    user_fav.user_id = ?\nGROUP BY\n    m_creation.creation_id, m_creation.creation_title, m_users.name\nORDER BY\n    like_count DESC;";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 414 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 436 */     catch (SQLException e) {
/* 437 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 442 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<CreationList> GetMyCreations(String user_id) {
/* 448 */     List<CreationList> list = new ArrayList<>();
/*     */     
/* 450 */     String sql = "SELECT\n    m_creation.creation_id AS novel_id,\n    m_creation.creation_title AS novel_title,\n    COUNT(m_creationfav.creationfav_id) AS like_count\nFROM\n    m_creation\nLEFT JOIN\n    m_creationfav ON m_creation.creation_id = m_creationfav.creation_id\nWHERE\n    m_creation.user_id = ?\nGROUP BY\n    m_creation.creation_id, m_creation.creation_title\nORDER BY\n    like_count DESC;\n";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 467 */       Exception exception2, exception1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 489 */     catch (SQLException e) {
/* 490 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 495 */     return list;
/*     */   }
/*     */ }

/*
	DECOMPILATION REPORT

	Decompiled from: C:\Users\Administrator\git\fresh_purple\CreationListSite\src\main\webapp\WEB-INF\classes/model/dao/CreationDAO.class61 ms
	
	Decompiled with CFR version 0.152.
*/