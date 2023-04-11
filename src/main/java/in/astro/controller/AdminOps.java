package in.astro.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import in.astro.bean.Book;
import in.astro.dao.IUserDao;
import in.astro.daofactory.UserDaoFactory;

@MultipartConfig
@WebServlet("/Admin11/*")
public class AdminOps extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		InputStream inputStream = null;
		Book book = new Book();
		if(request.getPathInfo().equals("/addbook")) {
			PrintWriter out = response.getWriter();
			IUserDao userdao = UserDaoFactory.getUserDao();
			out.println("<h1>hello sit down</h1>");
			Part filePart = request.getPart("image");
			if (filePart != null) {
				System.out.println("file part not null");
			    inputStream = filePart.getInputStream(); // get input stream of uploaded image
			}
			book.setImage(inputStream);
			book.setSid(Integer.parseInt(request.getParameter("id")));
			book.setAmount(Integer.parseInt(request.getParameter("amount")));
			book.setAuthor(request.getParameter("author"));
			book.setBookname(request.getParameter("name"));
			String status = userdao.addBook(book);
			if(status.equals("success")) out.println("<h1 style='color:green; text-align:center;'>Added Successfull</h1>");
			else out.println("<h1 style='color:red; text-align:center;'>Failed</h1>");
			inputStream.close();
			
		}
		if(request.getPathInfo().equals("/searchbook")) {
			
		}
	}
}
