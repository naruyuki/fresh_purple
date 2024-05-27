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
/*    */ @WebServlet({"/detail"})
/*    */ public class DetailServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 38 */     HttpSession session = request.getSession();
/* 39 */     request.setCharacterEncoding("UTF-8");
/*    */     
/* 41 */     String title = request.getParameter("creation_title");
/* 42 */     String id = request.getParameter("creation_id");
/*    */ 
/*    */     
/* 45 */     session.setAttribute("title", title);
/*    */ 
/*    */ 
/*    */     
/* 49 */     CreationDAO dao = new CreationDAO();
/*    */     
/* 51 */     CreationList res = dao.GetCreation(title);
/*    */     
/* 53 */     List<CreationList> resCom = dao.GetComments(id);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 62 */     session.setAttribute("result", res);
/* 63 */     session.setAttribute("comment", resCom);
/* 64 */     session.setAttribute("creation_id", id);
/*    */     
/* 66 */     RequestDispatcher rd = request.getRequestDispatcher("Detail.jsp");
/*    */     
/* 68 */     rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 78 */     doGet(request, response);
/*    */   }
/*    */ }

/*
	DECOMPILATION REPORT

	Decompiled from: C:\Users\Administrator\git\fresh_purple\CreationListSite\src\main\webapp\WEB-INF\classes/model/servlet/DetailServlet.class18 ms
	
	Decompiled with CFR version 0.152.
*/