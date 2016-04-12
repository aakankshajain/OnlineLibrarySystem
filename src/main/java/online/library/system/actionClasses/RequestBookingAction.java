package online.library.system.actionClasses;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RequestBookingAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String key=null;
		HttpSession ssn=request.getSession(true);
		
		try{
			//We will get the bookNumber of respective book button clicked.
			String bookNumber="receviedBookNumber";
			Configuration cfg=new Configuration();
			cfg.configure("/resources/hibernate.cfg.xml");
			SessionFactory sf=cfg.buildSessionFactory();
			Session session=sf.openSession();
			
			String hqlRequestQuery="update issueBook set status='Pending' and availability='N' and requestedUser='"+ssn.getAttribute("userName")+"' where bookNumber='"+bookNumber+"'";
			Query requestQuery=session.createQuery(hqlRequestQuery);
			int result=requestQuery.executeUpdate();
			if(result!=1){
				hqlRequestQuery="insert into issueBook(bookNumber,status,availability,requestedUser) values('"+bookNumber+"','Pending','N','"+ssn.getAttribute("userName")+"')";
				requestQuery=session.createQuery(hqlRequestQuery);
				result=(Integer) requestQuery.uniqueResult();
				if(result!=1){
					key="executionFailure";
				}else{
					key="success";
				}
			}else{
				key="success";
			}
			//A bean message will be set into bean telling success of request made for bookNumber. 
			
		}catch(Exception e){
			key="executionFailure";
		}
		return mapping.findForward(key);
	}

}
