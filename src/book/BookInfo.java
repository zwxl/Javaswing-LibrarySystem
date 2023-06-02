package book;

import java.io.Serializable;

public class BookInfo implements Serializable{
	private int id;
	private String bookNo;
	private String bookName;
	private String author;
	private String publisher;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public BookInfo(int id, String bookNo, String bookName, String author, String publisher) {
		super();
		this.id = id;
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
	}
	public BookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookInfo [id=" + id + ", bookNo=" + bookNo + ", bookName=" + bookName + ", author=" + author
				+ ", publisher=" + publisher + "]";
	}
	
	
}
