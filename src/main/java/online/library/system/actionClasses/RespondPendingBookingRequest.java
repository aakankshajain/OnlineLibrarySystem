package online.library.system.actionClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import online.library.system.POJOClasses.DataForRequestConfirmation;

public class RespondPendingBookingRequest extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response)
			throws Exception {
		String key=null;
		String buttonValue=null;
		Configuration cfg=new Configuration();
		cfg.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		ArrayList<DataForRequestConfirmation> dataList=new ArrayList<DataForRequestConfirmation>();
		
		buttonValue="buttonValueFromGUI";
		if(buttonValue==null||buttonValue==""){
			String hqlQuery="select bookNumber,studentId from issueBook where status='Pending'";
			Query q=session.createQuery(hqlQuery);
			List<Object> list=q.list();
			Iterator itr=list.iterator();
			while(itr.hasNext()){
				Object o[]=(Object[]) itr.next();
				DataForRequestConfirmation drc=new DataForRequestConfirmation(o[0].toString(), o[1].toString());
				dataList.add(drc);
			}
			
			/*
			 * This dataList will be set in corresponding bean file from it would be accessible on GUI.
			 * Where we will show this list in table format.
			 */
			
			key="success";
			
		}else if(buttonValue.equals("submit")){
			//We will get the list of bookNumbers which are checked for confirmation.
			ArrayList<String> checkedBookNumbers=new ArrayList<String>();
			String val=null;
			Iterator itr=checkedBookNumbers.iterator();
			DateFormat df=new SimpleDateFormat("DD-MM-YYYY");
			Date d=new Date();
			df.format(d);
			int month=d.getMonth();
			Date dueDate=new Date();
			String hqlQuery="update issueBook set studentId=requestedUser,issueDate='"+d+"',dueDate='"+dueDate+"',availability='N',requestedUser=null,status=null where bookNumber IN('";
			String hqlQueryReject="update issueBook set availability='Y',requestedUser=null,status=null where bookNumber not IN('";
			while(itr.hasNext()){
				val=(String) itr.next();
				hqlQuery+=val+"','";
				hqlQueryReject+=val+"','";
			}
			StringBuilder hqlQueryBuilder=new StringBuilder(hqlQuery);
			StringBuilder hqlQueryRejectBuilder=new StringBuilder(hqlQueryReject);
			
			int lastIndex=hqlQueryBuilder.lastIndexOf(",'");
			int lastIndexReject=hqlQueryRejectBuilder.lastIndexOf(",'");
			
			String hqlQuery_new=hqlQueryBuilder.substring(0, lastIndex-1);
			String hqlQueryReject_new=hqlQueryRejectBuilder.substring(0, lastIndexReject-1);
			
			hqlQuery_new.concat(")");
			hqlQueryReject_new.concat(")");
			
			Query q=session.createQuery(hqlQuery_new);
			Query qReject=session.createQuery(hqlQueryReject_new);
			
			
			
			int result=q.executeUpdate();
			int resultReject=qReject.executeUpdate();
			
			if(result!=1||resultReject!=1){
				key="executionFailure";
			}else{
				key="success";
			}
			
		}else{
			key="executionFailure";
		}
		return mapping.findForward(key);
	}
	

}
