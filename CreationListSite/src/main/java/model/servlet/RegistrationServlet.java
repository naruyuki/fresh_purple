package model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.RegisterDAO;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	HttpSession session =request.getSession();
	String user_id=request.getParameter("user_id");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	
	String url="";
	RegisterDAO dao = new RegisterDAO();
	int result =dao.registerUser(user_id, password, name);
	
	if(result==0) {
		session.setAttribute("message", "新規登録に失敗しました。");
		url= "Registration.jsp";
	}else {
		if(result==1) {
			session.setAttribute("message","登録完了しました。");
			url="UpCompleted.jsp";
		}
	}
	RequestDispatcher rd=request.getRequestDispatcher(url);
	rd.forward(request, response);
	
	
	
	
	
	}

}
