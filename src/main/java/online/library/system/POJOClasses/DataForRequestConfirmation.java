package online.library.system.POJOClasses;

public class DataForRequestConfirmation {
	private String bookNumber;
	private String studentId;
	public DataForRequestConfirmation(String bookNumber, String studentId) {
		super();
		this.bookNumber = bookNumber;
		this.studentId = studentId;
	}
	public String getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	

}
