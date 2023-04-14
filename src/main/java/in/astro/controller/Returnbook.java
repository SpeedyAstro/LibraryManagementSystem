package in.astro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.astro.bean.IssuedBook;
import in.astro.dao.IUserDao;
import in.astro.daofactory.UserDaoFactory;

/**
 * Servlet implementation class Returnbook
 */
@WebServlet("/returnbook")
public class Returnbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		IUserDao userDao = UserDaoFactory.getUserDao();
		List<IssuedBook> issuedBook = userDao.fetchIssuedBook();
		request.setAttribute("books", issuedBook);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
}
