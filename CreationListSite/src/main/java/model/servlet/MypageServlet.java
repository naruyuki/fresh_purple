/*    */ package model.servlet;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.List;

/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.annotation.WebServlet;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;

/*    */ import model.dao.CreationDAO;
/*    */ import model.entity.CreationList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @WebServlet({"/mypage"})
/*    */ public class MypageServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 38 */     HttpSession session = request.getSession();
/* 39 */     request.setCharacterEncoding("UTF-8");
/*    */     
/* 41 */     CreationDAO dao = new CreationDAO();
/*    */ 
/*    */     
/* 44 */     List<CreationList> likelist = dao.GetLikeCreations((String)session.getAttribute("user_id"));
/* 45 */     List<CreationList> mylist = dao.GetMyCreations((String)session.getAttribute("user_id"));
/*    */     
/* 47 */     session.setAttribute("likelist", likelist);
/* 48 */     session.setAttribute("mylist", mylist);
/*    */ 
/*    */ 
/*    */     
/* 52 */     RequestDispatcher rd = request.getRequestDispatcher("MyPage.jsp");
/*    */     
/* 54 */     rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 62 */     doGet(request, response);
/*    */   }
/*    */ }

/*
	DECOMPILATION REPORT

	Decompiled from: C:\Users\Administrator\git\fresh_purple\CreationListSite\src\main\webapp\WEB-INF\classes/model/servlet/MypageServlet.class24 ms
	
	Decompiled with CFR version 0.152.
*/