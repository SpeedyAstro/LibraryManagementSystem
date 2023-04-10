package in.astro.bean;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String view;
	@Override
	public String toString() {
		return "User [view=" + view + ", id=" + id + ", name=" + name + ", username=" + username + ", password="
				+ password + ", phoneno=" + phoneno + "]";
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	private int id;
	private String name;
	private String username;
	private String password;
	private String phoneno;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

}
