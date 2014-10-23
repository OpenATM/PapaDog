package action.user;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import common.impl.ServletHandleImpl;
import common.interf.IServletHandle;

import domain.model.User;

public class UserLoginAction extends ActionSupport implements ModelDriven<User>{
   private User user=new User();
   private IServletHandle ish=new ServletHandleImpl();

	public String login() {

		int x = 0;
		if (true) {             // ÷ÿ∏¥—È÷§
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("userName", user.getUserName());
			x = 1;
		}
		ish.writeToClient(ServletActionContext.getResponse(), "{\"result\":"
				+ x + "}");
		return null;
	}
	public String loginout(){
		HttpSession session = ServletActionContext.getRequest()
		.getSession();
		session.invalidate();
		this.ish.writeToClient(ServletActionContext.getResponse(), "{\"result\":1}");
		return null;
	}
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
