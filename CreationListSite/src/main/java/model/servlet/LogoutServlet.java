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
/*    */ @WebServlet({"/logout"})
/*    */ public class LogoutServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 35 */     response.getWriter().append("Served at: ").append(request.getContextPath());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 43 */     request.setCharacterEncoding("UTF-8");
/*    */     
/* 45 */     HttpSession session = request.getSession();
/*    */     
/* 47 */     session.removeAttribute("loginInfo");
/* 48 */     session.removeAttribute("user_id");
/*    */     
/* 50 */     RequestDispatcher rd = request.getRequestDispatcher("TopPage.jsp");
/*    */     
/* 52 */     rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ }

/*
	DECOMPILATION REPORT

	Decompiled from: C:\Users\Administrator\git\fresh_purple\CreationListSite\src\main\webapp\WEB-INF\classes/model/servlet/LogoutServlet.class33 ms
	
	Decompiled with CFR version 0.152.
*/