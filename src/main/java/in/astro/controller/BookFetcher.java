package in.astro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.astro.bean.Book;
import in.astro.dao.IUserDao;
import in.astro.daofactory.UserDaoFactory;

/**
 * Servlet implementation class BookFetcher
 */
@WebServlet("/fetch")
public class BookFetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		if(request.getRequestURI().endsWith("all")) 
				IUserDao userDao = UserDaoFactory.getUserDao();
				List<Book> books = userDao.fetchbook();
//				System.out.println(books);
				ServletContext context = request.getServletContext();
				 Book book = books.get(0);
				Book book1 = books.get(1);

//				context.setAttribute("books", books);
//				System.out.println(book.getBookname());
//				System.out.println(book1.getBookname());
				request.setAttribute("books", books);
//				HttpSession session = request.getSession();
//				session.setAttribute("books", books);
		
	}

}
