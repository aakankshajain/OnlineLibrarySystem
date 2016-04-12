package online.library.system.actionClasses;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import online.library.system.POJOClasses.BookRegistration;
import online.library.system.POJOClasses.UserRegisteration;
import online.library.system.bean.BookRegistrationBean;
import online.library.system.bean.UserRegisterationBean;
import online.library.system.POJOClasses.UserRegisteration;

public class BookRegistrationAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String key=null;
		String buttonValue=null;
		/*
		 * buttonValue will set from jsp page.Initially it will be null.
		 * On clicking submit button it will be "submit".
		 */
		if(buttonValue.equals("submit")){
			Configuration cfg=new Configuration();
			cfg.configure("/resources/hibernate.cfg.xml");
			SessionFactory sf=cfg.buildSessionFactory();
			Session session=sf.openSession();
			BookRegistrationBean bean=(BookRegistrationBean) form;
			/*
			 * Assuming that input for registration will come from GUI through bean class.
			 * bean class will contain all getters and setters method.
			 * so for single student taking it hard coded.
			 * This method will be called when user will click on submit button on registeration page.
			 */
			String bookNumber="booknumber";
			String bookName="bookname";
			String author="author";
			String subject="subject";
			String bookType="e";
			
			/*
			 * if bookType is 'e'(e book) we will store input stream of browsed file.
			 * That will be converted into original file on download button.
			 * 
			 * if bookType is 'p' no file will be browsed.
			 * 
			 * 
			 */
			
			FormFile eBookBrowsed=null;//Will be taken from GUI
			String eBook="inputStreamOfEbookBrowsed";
			BookRegistration book=new BookRegistration();
			book.setBookName(bookName);
			book.setBookNumber(bookNumber);
			book.setAuthor(author);
			book.setSubject(subject);
			book.setBookType(bookType);
			book.seteBook(eBook);
			try{
				session.save(book);
				session.beginTransaction().commit();
				key="success";
			}catch(Exception e){
				//again set buttonValue =null
				key="executionFailure";
			}
			//again set buttonValue =null
		}else{
			key="success";
		}
				
		/*
		 * After execution page will be redirected to new JSP page according to result.
		 * In case any exception occured page will be redirected to error page.
		 * This mapping will be present in struts.config file. 
		 */
		
		return mapping.findForward(key);
	}
	
	
}
