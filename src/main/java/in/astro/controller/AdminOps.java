package in.astro.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;

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
		try {
			doProcess(request,response);
		} catch (ClassNotFoundException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (ClassNotFoundException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
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
		if(request.getPathInfo().equals("/updatebook")) {
			PrintWriter out = response.getWriter();
			IUserDao userdao = UserDaoFactory.getUserDao();
			String bookname = request.getParameter("book");
			System.out.println(bookname);
			Book newbook =  userdao.getbook(bookname);
			request.setAttribute("book", newbook);
			request.getRequestDispatcher("/editbook.jsp").forward(request, response);
			
		}
		if(request.getPathInfo().equals("/editbook")) {
			Book newbook = new Book();
			InputStream stream = null;
			IUserDao userdao = UserDaoFactory.getUserDao();
			PrintWriter out = response.getWriter();
			newbook.setBookname(request.getParameter("name"));
			newbook.setAuthor(request.getParameter("author"));
			newbook.setSid(Integer.parseInt(request.getParameter("id")));
			newbook.setAmount(Integer.parseInt(request.getParameter("amount")));
			Part filePart = request.getPart("image");
			if (filePart != null && filePart.getSize() > 0) {
				stream = filePart.getInputStream(); // get input stream of uploaded image
				newbook.setImage(stream);
			} else {
//				todo:: default image is not setting need to get object from editbook.jsp
				String b1 = request.getParameter("defaultbook");
				byte[] imageData = Base64.getDecoder().decode(b1);
				stream = new ByteArrayInputStream(imageData);
				newbook.setImage(stream);
			}
			if(newbook.getImage()!=null) System.out.println("book image is not null");
			String status = userdao.updatebook(newbook);
			if(status.equals("success")) out.println("<h1 style='color:green; text-align:center;'>Added Successfull</h1>");
			else out.println("<h1 style='color:red; text-align:center;'>Failed</h1>");
			stream.close();
		}
	}
}
