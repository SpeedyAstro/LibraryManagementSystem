package in.astro.bean;

import java.io.InputStream;
import java.io.Serializable;

public class Book implements Serializable {
	InputStream image = null;
	private String bookname;
	private String author;
	private int sid;
	private int amount;
	private String Discription;
	private byte[] imagedata;
	
	public byte[] getImagedata() {
		return imagedata;
	}
	public void setImagedata(byte[] imagedata) {
		this.imagedata = imagedata;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	public String getBookname() {
		return bookname;
	}
	@Override
	public String toString() {
		return "Book [image=" + image + ", bookname=" + bookname + ", author=" + author + ", sid=" + sid + ", amount="
				+ amount + "]";
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
}
