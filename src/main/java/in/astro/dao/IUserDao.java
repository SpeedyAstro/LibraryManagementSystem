package in.astro.dao;

import java.util.List;

import in.astro.bean.Book;
import in.astro.bean.IssuedBook;
import in.astro.bean.User;

public interface IUserDao {
	public String addUser(User user);
	public User searchUser(String username,String password);
	public String addBook(Book book);
	public List<Book> fetchbook() ;
	public List<Book> fetchbook(String name);
	public Book getbook(String name);
	public String updatebook(Book book);
	public String deletebook(String name);
	public boolean issueBook(String name,int id);
	public String setIssueBookDB(IssuedBook book);
	public List<IssuedBook> fetchIssuedBook(int id);
	public List<IssuedBook> fetchIssuedBook();
	public String returnbook(String book_name,int id);
}