package in.astro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.astro.bean.Book;
import in.astro.dao.IUserDao;
import in.astro.daofactory.UserDaoFactory;

/**
 * Servlet implementation class SearchQuery
 */
@WebServlet("/searchbooks")
public class SearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserDao userdao = UserDaoFactory.getUserDao();
		String query = request.getParameter("query");
		List<Book> books = userdao.fetchbook(query);
		request.setAttribute("books", books);
		request.getRequestDispatcher("searchResults.jsp").forward(request, response);
	}

}
