package online.library.system.POJOClasses;

import java.io.InputStream;

public class SearchResultForUser {
	
	private String bookNumber;
	private String bookName;
	private String author;
	private String subject;
	private String bookType;
	private InputStream eBook;
	private String availability;
	
	
	public SearchResultForUser(String bookNumber,String bookName, String author, String subject, String bookType, InputStream eBook,
			String availability) {
		super();
		this.bookNumber=bookNumber;
		this.bookName = bookName;
		this.author = author;
		this.subject = subject;
		this.bookType = bookType;
		this.eBook = eBook;
		this.availability = availability;
	}
	
	
	public String getBookNumber() {
		return bookNumber;
	}


	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public InputStream geteBook() {
		return eBook;
	}
	public void seteBook(InputStream eBook) {
		this.eBook = eBook;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	

}
