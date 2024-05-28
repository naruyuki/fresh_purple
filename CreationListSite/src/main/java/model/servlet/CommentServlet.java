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
 * Servlet implementation class CommentServlet
 */
@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
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
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		String user_id = (String)session.getAttribute("user_id");
		int creation_id =Integer.parseInt(request.getParameter("creation_id"));
		String comment = request.getParameter("comment");
		String from = request.getParameter("from");
		
		CreationDAO dao = new CreationDAO();
		
		dao.uploadComment(user_id, comment, creation_id);

		
		
		RequestDispatcher rd = request.getRequestDispatcher(from);
		rd.forward(request, response);
		
		
		
		
	}

}
