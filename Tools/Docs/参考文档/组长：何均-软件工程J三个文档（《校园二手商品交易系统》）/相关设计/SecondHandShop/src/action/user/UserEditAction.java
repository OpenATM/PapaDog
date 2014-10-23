package action.user;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import service.impl.IUsers;
import service.interf.UsersImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import common.impl.ServletHandleImpl;
import common.interf.IServletHandle;
import domain.model.User;

public class UserEditAction extends ActionSupport implements ModelDriven<User>{
	private IServletHandle ish=new ServletHandleImpl();
    private User user=new User();
    private IUsers iUsers=new UsersImpl();
   
	public IServletHandle getIsh() {
		return ish;
	}
	public void setIsh(IServletHandle ish) {
		this.ish = ish;
	}
	public void regist(){
		int x=iUsers.addUser(user);
	}
	public void add() {
	    int x=iUsers.addUser(user);
		ish.writeToClient(ServletActionContext.getResponse(), "{\"result\":"+x+"}");
	}

	public void del(){
	    int x=iUsers.delUser(user);
		ish.writeToClient(ServletActionContext.getResponse(), "{\"result\":"+x+"}");		
	}
	
	public void edit(){
	    int x=iUsers.updateUser(user);
		ish.writeToClient(ServletActionContext.getResponse(), "{\"result\":"+x+"}");		
	}
	
	public void findUserById(){
	    String userStr=iUsers.findUserById(user.getId());
		ish.writeToClient(ServletActionContext.getResponse(), "{\"result:1\":"+userStr+"}");		
	}
	public User getModel() {		
		return user;
	}
}
