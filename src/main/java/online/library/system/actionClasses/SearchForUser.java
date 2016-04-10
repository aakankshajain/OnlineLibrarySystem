package online.library.system.actionClasses;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SearchForUser extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response)throws Exception {
		
		String key=null;
		String buttonValue=null;//button value will be fetched from bean class which was set in jsp file
		if(buttonValue==null||buttonValue==""){
			key="success";
		}else if(buttonValue.equals("search")){
			
			//Logic to be written.
		}else{
			key="executionFailure";
		}
		
		return mapping.findForward(key);
	}

}
