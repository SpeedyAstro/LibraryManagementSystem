package in.astro.dao;

import in.astro.bean.Book;
import in.astro.bean.User;

public interface IUserDao {
	public String addUser(User user);
	public User searchUser(String username,String password);
	public String addBook(Book book);
}