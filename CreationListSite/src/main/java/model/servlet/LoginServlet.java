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
/*    */ @WebServlet({"/login"})
/*    */ public class LoginServlet
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
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 45 */     request.setCharacterEncoding("UTF-8");
/*    */     
/* 47 */     HttpSession session = request.getSession();
/*    */ 
/*    */ 
/*    */     
/* 51 */     String user_id = request.getParameter("user_id");
/* 52 */     String password = request.getParameter("password");
/*    */ 
/*    */     
/* 55 */     String url = "";
/*    */     
/* 57 */     CreationDAO dao = new CreationDAO();
/*    */     
/* 59 */     if (dao.LoginCertification(user_id, password).equals("")) {
/*    */ 
/*    */       
/* 62 */       session.setAttribute("error", "ユーザ名、またはパスワードが違います。");
/*    */       
/* 64 */       url = "Login.jsp";
/*    */     
/*    */     }
/*    */     else {
/*    */ 
/*    */       
/* 70 */       if (session.getAttribute("error") != null)
/*    */       {
/* 72 */         session.removeAttribute("error");
/*    */       }
/*    */ 
/*    */       
/* 76 */       session.setAttribute("loginInfo", dao.LoginCertification(user_id, password));
/* 77 */       session.setAttribute("user_id", user_id);
/*    */ 
/*    */ 
/*    */       
/* 81 */       url = "TopPage.jsp";
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 89 */     RequestDispatcher rd = request.getRequestDispatcher(url);
/*    */     
/* 91 */     rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ }