package online.library.system.POJOClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="UserRegistration")
public class UserRegisteration {
	
	@Id
	@Column(name="studentId")
	private String studentId;
	
	@Column(name="name")
	private String name;
	
	@Email
	@Column(name="emailId")
	private String emailId;
	
	@Max(value=10, message="Phone number can not be more than 10 digit")
	@Min(value=10,message="Phone number can not be less than 10 digit")
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="password")
	private String password;
	
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
