package model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CreationDAO;

/**
 * Servlet implementation class EditUserInfoServlet
 */
@WebServlet("/edituserinfo")
public class EditUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		String user_id = (String)session.getAttribute("user_id");
		
		String newName = request.getParameter("name");
		
		
		CreationDAO dao = new CreationDAO();
		
		if(dao.updateName(user_id, newName)==1) {
			session.setAttribute("loginInfo", newName);
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("MyPage.jsp");
		
		rd.forward(request, response);
		
		
	}

}
