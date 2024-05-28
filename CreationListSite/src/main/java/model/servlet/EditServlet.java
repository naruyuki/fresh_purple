package model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CreationDAO;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		
		HttpSession session = request.getSession();
		
		String title = request.getParameter("rough_title");
		String text = request.getParameter("rough_text");
		String id = request.getParameter("rough_id");
		int genre_id = Integer.parseInt(request.getParameter("genre_id"));
		
		CreationDAO dao = new CreationDAO();
		
		if(dao.uploadRough(title, text, id, genre_id) == 1) {
			session.setAttribute("title", title);
			session.setAttribute("text", text);
			session.setAttribute("id", id);
			session.setAttribute("genre_id", genre_id);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("EditCreation.jsp");
		rd.forward((ServletRequest)request, (ServletResponse)response);
	}

}
