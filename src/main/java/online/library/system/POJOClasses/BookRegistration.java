package online.library.system.POJOClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="bookRegistration")
public class BookRegistration {
	
	@Id
	@Column(name="bookNumber")
	private String bookNumber;
	
	@Column(name="bookName")
	private String bookName;
	
	@Column(name="author")
	private String author;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="bookType")
	private String bookType;
	
	@Column(name="eBook")
	private String eBook;
	
	
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

	public String geteBook() {
		return eBook;
	}

	public void seteBook(String eBook) {
		this.eBook = eBook;
	}
	
	
	
}
