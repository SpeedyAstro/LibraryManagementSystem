package in.astro.dao;

import in.astro.bean.User;

public interface IUserDao {
	public String addStudent(User user);
	public User searchUser(String username,String password);
}
