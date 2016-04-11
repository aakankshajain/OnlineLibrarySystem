package online.library.system.actionClasses;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import online.library.system.POJOClasses.SearchResultForUser;

public class SearchForUser extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response)throws Exception {
		
		String key=null;
		String buttonValue=null;//button value will be fetched from bean class which was set in jsp file
		
		
		String nameSearch=null;
		String authorSearch=null;
		String subjectSearch=null;
		String hqlQuery=null;
		ArrayList<SearchResultForUser> searchRecord=new ArrayList<SearchResultForUser>();
		
		buttonValue="ReceivedButtonValue";
		if(buttonValue==null||buttonValue==""){
			key="success";
		}else if(buttonValue.equals("search")){
			
			Configuration cfg=new Configuration();
			cfg.configure("resources/hibernate.cfg.xml");
			SessionFactory sf=cfg.buildSessionFactory();
			Session session=sf.openSession();
			
			/*
			 * Take the values of variables nameSearch,authorSearch,subjectSearch
			 * from GUI through bean.
			 */
			nameSearch="searchValueEnteredInNameTextbox";
			authorSearch="searchValueEnteredInAuthorTextbox";
			subjectSearch="searchValueEnteredInSubjectTextbox";
			if((nameSearch==null||nameSearch=="")&&(authorSearch==null||authorSearch=="")&&(subjectSearch==null||subjectSearch=="")){
				hqlQuery="select b.bookNumber,b.bookName,b.author,b.subject,b.bookType,b.ebook,i.availability from bookRegistration,bookIssue";
			}else if(!(nameSearch==null&&nameSearch=="")){
				if(!(authorSearch==null&&authorSearch=="")){
					if(!(subjectSearch==null&&subjectSearch=="")){
						hqlQuery="select b.bookNumber,b.bookName,b.author,b.subject,b.bookType,b.ebook from bookRegistration"
								+ " where b.bookName=%"+nameSearch+"% and b.author=%"+authorSearch+"% and b.subject=%"+subjectSearch+"%";
					}else{
						hqlQuery="select b.bookNumber,b.bookName,b.author,b.subject,b.bookType,b.ebook from bookRegistration "
								+ "where b.bookName=%"+nameSearch+"% and b.author=%"+authorSearch+"%";

					}
				}else{
					hqlQuery="select b.bookNumber,b.bookName,b.author,b.subject,b.bookType,b.ebook from bookRegistration "
							+ "where b.bookName=%"+nameSearch+"%";

				}
				
			}
			
			Query q=session.createQuery(hqlQuery);
			List<Object> list=	q.list();
			String hqlAvlQuery="select availability from issueBook where bookNumber='";
			Iterator<Object> itr=list.iterator();
			while(itr.hasNext()){
				Object o[]=(Object[]) itr.next();
				hqlAvlQuery=hqlAvlQuery+o[0]+"'";
				Query hqlAvailq=session.createQuery(hqlAvlQuery);
				String avl=(String) hqlAvailq.uniqueResult();
				SearchResultForUser srchUser=new SearchResultForUser(o[0].toString(), o[1].toString(), o[2].toString(), o[3].toString(), o[4].toString(), (InputStream)o[5], avl);
				searchRecord.add(srchUser);
			}
			
			
		}else{
			key="executionFailure";
		}
		
		return mapping.findForward(key);
	}

}
