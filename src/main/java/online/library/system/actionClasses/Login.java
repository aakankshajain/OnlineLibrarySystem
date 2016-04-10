package online.library.system.actionClasses;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.action.spi.Executable;
import org.hibernate.cfg.Configuration;

import online.library.system.POJOClasses.UserRegisteration;
import online.library.system.bean.LoginBean;
import online.library.system.utility.CommonConstants;

public class Login extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response)
			throws Exception {
		
		/*
		 * Here I am assuming that user name and password is coming from login page through 
		 * bean file. 
		 * user name and password is already fixed for librarian that can be present in property file.
		 * I am taking it as a constant.
		 * For users username = ID
		 * and password= set at registration time
		 */
		
		String uname="username";
		String password="password";
		LoginBean bean=(LoginBean) form;
		String key=null;
		Configuration cfg=new Configuration();
		cfg.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		if(uname.equals(CommonConstants.LIBRAIAN_USERNAME)&&password.equals(CommonConstants.LIBRARIAN_PASSWORD)){
			key="libLogin";
		}
		else{
			String hql="select password from UserRegisteration where studentId='"+uname+"'";
			Query query=session.createQuery(hql);
			UserRegisteration record=(UserRegisteration) query.uniqueResult();
			if(record==null){
				/*
				 * Here we will be setting message "You are not registered user"
				 * in message field present on jsp page through bean class. 
				 */
				key="loginFailed";
				
			}else if(!record.getPassword().equals(password)){
				/*
				 * Here we will be setting message "Invalid user-name or password"
				 * in message field present on jsp page through bean class. 
				 */
				key="loginFailed";
			}else{
				key="userLogin";
			}
		}
		
		/*
		 * According to key values user will be redirected to corresponding page.
		 * this key value to page mapping will be available in WEB-INF/struts.config file.
		 */
		return mapping.findForward(key);
	}

	
	
}
