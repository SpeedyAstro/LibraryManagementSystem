package in.astro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.astro.bean.User;
import in.astro.dao.IUserDao;
import in.astro.daofactory.UserDaoFactory;

/**
 * Servlet implementation class LoginValidation
 */
@WebServlet("/login")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		IUserDao userservice = UserDaoFactory.getUserDao();
		User user = userservice.searchUser(request.getParameter("username"), request.getParameter("password"));
		RequestDispatcher dispatcher = null;
		if(user!=null) {
			if(user.getView().equalsIgnoreCase("student")) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				dispatcher = request.getRequestDispatcher("./student.jsp");
			}else if(user.getView().equalsIgnoreCase("admin")) {
				request.setAttribute("user", user);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
	//			todo: create differnt page for unknown user
				dispatcher = request.getRequestDispatcher("./Admin1.jsp");
				System.out.println("i m admin");
				dispatcher.forward(request, response);
			}
		}else {
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("./login.jsp");
		}
		dispatcher.forward(request, response);
		if(user!=null) out.println("<h1 style='color:green;text-align:center;'>"+user+"</h1>");
	}

}
