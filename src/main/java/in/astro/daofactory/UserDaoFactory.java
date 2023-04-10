package in.astro.daofactory;

import in.astro.dao.IUserDao;
import in.astro.dao.UserDaoImpl;

public class UserDaoFactory {
	private UserDaoFactory() {
		
	}
	private static IUserDao userdao = null;
	public static IUserDao getUserDao() {
		if(userdao == null)
			userdao = new UserDaoImpl();
		return userdao;
	}
}
