/*    */ package model.servlet;
/*    */ 
/*    */ import java.io.IOException;

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
/*    */ @WebServlet({"/creationlike"})
/*    */ public class CreationLikeServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 36 */     response.getWriter().append("Served at: ").append(request.getContextPath());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 44 */     request.setCharacterEncoding("UTF-8");
/*    */     
/* 46 */     HttpSession session = request.getSession();
/*    */     
/* 48 */     String user_id = (String)session.getAttribute("user_id");
/*    */     
/* 50 */     String creation_id = request.getParameter("creation_id");
/*    */     
/* 52 */     CreationDAO dao = new CreationDAO();
/* 53 */     CreationList res = dao.GetCreation((String)session.getAttribute("title"));
/*    */     
/* 55 */     session.setAttribute("result", res);
/*    */ 
/*    */     
/* 58 */     session.setAttribute("creation_id", creation_id);
/*    */     
/* 60 */     if (!dao.CheckLikeCreation(user_id, creation_id))
/*    */     {
/* 62 */       dao.LikeCreation(user_id, creation_id);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 68 */     RequestDispatcher rd = request.getRequestDispatcher("Detail.jsp");
/*    */     
/* 70 */     rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ }

/*
	DECOMPILATION REPORT

	Decompiled from: C:\Users\Administrator\git\fresh_purple\CreationListSite\src\main\webapp\WEB-INF\classes/model/servlet/CreationLikeServlet.class19 ms
	
	Decompiled with CFR version 0.152.
*/