package in.astro.bean;

import java.util.Date;

public class IssuedBook {
	private String Bookname;
	private int userId;
	private Date IssuedDate;
	private Date ReturnDate;
	private int fine;
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getIssuedDate() {
		return IssuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		IssuedDate = issuedDate;
	}
	public Date getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	@Override
	public String toString() {
		return "IssuedBook [Bookname=" + Bookname + ", userId=" + userId + ", IssuedDate=" + IssuedDate
				+ ", ReturnDate=" + ReturnDate + ", fine=" + fine + "]";
	}
	
}
