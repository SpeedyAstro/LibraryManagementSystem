package in.astro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.astro.bean.Book;
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
		String query = "select uid,name,username,password,phoneno,view from library where username=? and password=?";
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

}












