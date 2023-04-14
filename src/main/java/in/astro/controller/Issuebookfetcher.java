package in.astro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.astro.bean.IssuedBook;
import in.astro.bean.User;
import in.astro.dao.IUserDao;
import in.astro.daofactory.UserDaoFactory;

/**
 * Servlet implementation class Issuebookfetcher
 */
@WebServlet("/issue1")
public class Issuebookfetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		IUserDao userDao = UserDaoFactory.getUserDao();
		List<IssuedBook> issuedBook = userDao.fetchIssuedBook(user.getUniqueId());
		request.setAttribute("books", issuedBook);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
