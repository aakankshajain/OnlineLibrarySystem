package online.library.system.actionClasses;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import online.library.system.POJOClasses.UserRegisteration;

import online.library.system.POJOClasses.UserRegisteration;

public class UserRegisterationAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String key="success";
		Configuration cfg=new Configuration();
		cfg.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		/*
		 * Assuming that input for registration will come from GUI.
		 * so for single student taking it hard coded.
		 * This method will be called when user will click on submit button on registeration page.
		 */
		String studentID="BTBTC10089";
		String name="aakanksha";
		String password="aakanksha@5";
		String emailId="aakanksha.bwr@gmail.com";
		String phoneNumber="1234567890";
		
		UserRegisteration student=new UserRegisteration();
		student.setName(name);
		student.setEmailId(emailId);
		student.setPassword(password);
		student.setPhoneNumber(phoneNumber);
		student.setStudentId(studentID);
		
		session.save(student);
		session.beginTransaction().commit();
		return mapping.findForward(key);
	}
	
	
}
