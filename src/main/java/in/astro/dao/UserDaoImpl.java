package in.astro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.astro.bean.Book;
import in.astro.bean.IssuedBook;
import in.astro.bean.User;
import in.astro.util.JdbcUtil;

public class UserDaoImpl implements IUserDao {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultset = null;
	User user = null;
	Book book = null;

	@Override
	public String addUser(User user) {
		this.user = user;
		String query = "insert into library(`uid`,`name`,`username`,`password`,`phoneno`,`view`) values(?,?,?,?,?,?)";
		try {
			connection = JdbcUtil.getConnection();
			if(connection!=null) 
				statement = connection.prepareStatement(query);
				System.out.println(user);
				if(statement!=null) {
					statement.setInt(1, user.getId());
					statement.setString(2, user.getName());
					statement.setString(3, user.getUsername());
					statement.setString(4, user.getPassword());
					statement.setString(5, user.getPhoneno());
					statement.setString(6, user.getView());
					int rowaffected = statement.executeUpdate();
					if(rowaffected==1)	return "success";
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}
	
	public User searchUser(String username,String password) {
		String query = "select uid,name,username,password,phoneno,view,id from library where username=? and password=?";
		User user1 = new User();
		try {
			connection = JdbcUtil.getConnection();
			if(connection!=null)
				statement = connection.prepareStatement(query);
				if(statement!=null) {
					statement.setString(1, username);
					statement.setString(2, password);
					resultset = statement.executeQuery();
					if(resultset!=null) {
						if(resultset.next()) {
							user1.setId(resultset.getInt(1));
							user1.setName(resultset.getString(2));
							user1.setUsername(resultset.getString(3));
							user1.setPassword(resultset.getString(4));
							user1.setPhoneno(resultset.getString(5));
							user1.setView(resultset.getString(6));
							user1.setUniqueId(resultset.getInt(7));
							return user1;
						}
					}
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addBook(Book book) {
		String query = "insert into book(`bid`,`bookname`,`author`,`amount`,`image`) values(?,?,?,?,?)";
		this.book = book;
		try {
			connection = JdbcUtil.getConnection();
			if(connection!=null)
				statement = connection.prepareStatement(query);
				if(statement!=null) {
					statement.setInt(1, book.getSid());
					statement.setString(2, book.getBookname());
					statement.setString(3, book.getAuthor());
					statement.setInt(4, book.getAmount());
					statement.setBinaryStream(5, book.getImage(), book.getImage().available());
					int count = statement.executeUpdate();
					if(count==1) return "success";
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}
	public List<Book> fetchbook() {
//		ResultSet resultset = null;
		String query = "select bid,bookname,author,amount,image from book";
//		Book b = new Book();
		try {
			connection = JdbcUtil.getConnection();
			List<Book> books = new ArrayList<Book>();
			if(connection!=null)
				statement = connection.prepareStatement(query);
				if(statement!=null) {
					 resultset = statement.executeQuery();
					 while(resultset.next()) {
						 Book b = new Book();
						 b.setSid(resultset.getInt(1));
						 System.out.println(resultset.getInt(1));
						 b.setBookname(resultset.getString(2));
						 b.setAuthor(resultset.getString(3));
						 b.setAmount(resultset.getInt(4));
						 b.setImagedata(resultset.getBytes("image"));
						 books.add(b);
					 }
					 System.out.println("hello test :"+books==null+"");
					 return books;
				}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public List<Book> fetchbook(String name){
		String query = "select bid,bookname,author,amount,image from book where bookname=? or author=?"; 
		try {
			connection = JdbcUtil.getConnection();
			List<Book> books = new ArrayList<Book>();
			if(connection!=null)
				statement = connection.prepareStatement(query);
				if(statement!=null) {
					statement.setString(1, name);
					statement.setString(2, name);
					resultset = statement.executeQuery();
					while(resultset.next()) {
						Book b = new Book();
						b.setSid(resultset.getInt(1));
//						 System.out.println(resultset.getInt(1));
						 b.setBookname(resultset.getString(2));
						 b.setAuthor(resultset.getString(3));
						 b.setAmount(resultset.getInt(4));
						 b.setImagedata(resultset.getBytes("image"));
						 books.add(b);
					}
					return books;
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Book getbook(String name){
		String query = "select bid,bookname,author,amount,image from book where bookname=?"; 
		Book b = new Book();
		try {
			connection = JdbcUtil.getConnection();
			if(connection!=null)
				statement = connection.prepareStatement(query);
				if(statement!=null) {
					statement.setString(1, name);
					resultset = statement.executeQuery();
					if(resultset.next()) {
						b.setSid(resultset.getInt(1));
						 System.out.println(resultset.getInt(1));
						 b.setBookname(resultset.getString(2));
						 b.setAuthor(resultset.getString(3));
						 b.setAmount(resultset.getInt(4));
						 b.setImagedata(resultset.getBytes("image"));
					}
					return b;
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String updatebook(Book editbook) {
		String query = "update book set bookname=?,author=?,amount=?,image=? where bid=?";
		try {
			connection = JdbcUtil.getConnection();
			if(connection!=null)
				statement = connection.prepareStatement(query);
				if(statement!=null) {
					statement.setString(1, editbook.getBookname());
					statement.setString(2, editbook.getAuthor());
					statement.setInt(3, editbook.getAmount());
					if(editbook.getImage()!=null) System.out.println("book image is not null in dao layer");
					statement.setBinaryStream(4, editbook.getImage(), editbook.getImage().available());
					statement.setInt(5, editbook.getSid());
					int count = statement.executeUpdate();
					if(count==1) return "success";
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String deletebook(String name) {
		String query = "delete from book where bookname=?";
		try {
			connection = JdbcUtil.getConnection();
			if(connection!=null)
				statement = connection.prepareStatement(query);
				if(statement!=null) {
					statement.setString(1, name);
					int count = statement.executeUpdate();
					if(count==1) return "success";
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}
	public boolean issueBook(String name,int id) {
		Connection connection = null;

		String query = "UPDATE book SET amount = amount - 1 WHERE bookname = ? and amount>0";
		String issuequery = "UPDATE library set issue_count = issue_count + 1 where id=? and issue_count<4";
		int book_count = 0, issue_count = -1;
		try {
			connection = JdbcUtil.getConnection();
			connection.setAutoCommit(false);
			if(connection!=null) {
				statement = connection.prepareStatement(query);
				if(statement!=null) {
					statement.setString(1, name);
					 book_count = statement.executeUpdate();
				}
				PreparedStatement issuecountStatement = connection.prepareStatement(issuequery);
				issuecountStatement.setInt(1, id);
				issue_count = issuecountStatement.executeUpdate();
				
			}
			if(book_count>0 && issue_count>0 ) {
				connection.commit();
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;	
	}
//	public 

	@Override
	public String setIssueBookDB(IssuedBook book) {
		String query = "insert into issuedbook (user_id,book_name,issue_date,return_date,fine_amount) values (?,?,?,?,?)";
		try {
			connection = JdbcUtil.getConnection();
			if(connection!=null) {
				statement = connection.prepareStatement(query);
				statement.setInt(1, book.getUserId());
				statement.setString(2, book.getBookname());
				statement.setDate(3, new java.sql.Date(book.getIssuedDate().getTime()));
				statement.setDate(4, new java.sql.Date(book.getReturnDate().getTime()));
				statement.setInt(5, book.getFine());
				int rowcount = statement.executeUpdate();
				if(rowcount==1) return "success";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}
}












