package in.astro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.astro.bean.User;
import in.astro.dao.IUserDao;
import in.astro.daofactory.UserDaoFactory;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/validate")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserDao userservice = UserDaoFactory.getUserDao();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		String number = request.getParameter("contact");
		String view = request.getParameter("view");
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhoneno(number);
		user.setView(view);
		String status = userservice.addUser(user).toLowerCase();
		request.setAttribute("status", status);
		RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
		dispatcher.forward(request, response);
	}

}
