package in.astro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
 * Servlet implementation class StudentOps
 */
@WebServlet("/student/*")
public class StudentOps extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {

		if(request.getPathInfo().equals("/issuebook")) {
			IssuedBook issuebook = new IssuedBook();
			String bookname = request.getParameter("book");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
		    User user = (User) session.getAttribute("user");
			IUserDao userdao = UserDaoFactory.getUserDao();
			boolean status = userdao.issueBook(bookname,user.getUniqueId());
			if(status) {
				issuebook.setBookname(bookname);
				issuebook.setUserId(user.getUniqueId());
				issuebook.setIssuedDate(new Date());
				issuebook.setReturnDate(new Date(System.currentTimeMillis() + (15 * 24 * 60 * 60 * 1000))); 
			    issuebook.setFine(0);
			    System.out.println(issuebook.getReturnDate());
			    String flag = userdao.setIssueBookDB(issuebook);
			   if(flag.equals("success"))  out.println("<h1 style='color:green;text-align:center;'> Successfully Added to IssuedBookdb</h1>");
			   else  out.println("<h1 style='color:red;text-align:center;'> Failed to add  IssuedBookdb</h1>");
			}else {
				out.println("<h1 style='color:red;text-align:center;'> Failed to Issue Book [you MAXED OUT ISSUE BOOK LIMIT OR BOOK IS NOT AVAILABLE RIGHT NOW </h1>");
			}
		}
		if(request.getPathInfo().equals("/fetchbook")) {
			HttpSession session = request.getSession();
		    User user = (User) session.getAttribute("user");
			IUserDao userDao = UserDaoFactory.getUserDao();
			List<IssuedBook> issuedBook = userDao.fetchIssuedBook(user.getUniqueId());
			request.setAttribute("books", issuedBook);
		}
	}

}
