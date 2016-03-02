package org.interceptor;

import java.util.Map;
import org.been.Userinfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


public class AuthenticationInterceptor implements Interceptor  {

	 private static final long serialVersionUID = 1L;
	 
	 private String message;
	
	 public static final String USER_SESSION_KEY = "UserSessionKey";
	 
	 public void destroy() {}

	 public void init() {}

     public String intercept(ActionInvocation actionInvocation) throws Exception {
		 //ȡ��Session
         Map session = actionInvocation.getInvocationContext().getSession();
		 //��Session���õ�¼ʱ�����session��User��
         Userinfo userinfo = (Userinfo) session.get(USER_SESSION_KEY);
         //����û�Ϊ�գ����ص�¼ҳ��  	 
         if (userinfo==null) {
        	 this.setMessage("��û��½");
            return Action.INPUT;           
         }        
         return actionInvocation.invoke();//������֤ͨ��         
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}