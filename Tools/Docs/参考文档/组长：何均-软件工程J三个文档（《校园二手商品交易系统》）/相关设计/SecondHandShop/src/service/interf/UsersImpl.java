package service.interf;

import net.sf.json.JSONObject;

import org.hibernate.HibernateException;

import dao.impl.UserDao;
import dao.intef.IUserDao;
import domain.model.User;
import service.impl.IUsers;

public class UsersImpl implements IUsers {
    private IUserDao userDao=new UserDao();
	public int addUser(User user) {
		try{
			  userDao.addUser(user);
			}
			catch(HibernateException e){
				e.printStackTrace();
				return 0;		
			}
			return 1;	
	}

	public int delUser(User user) {
		try{
			  userDao.deleteUser(user);
			}
			catch(HibernateException e){
				e.printStackTrace();
				return 0;		
			}
			return 1;	
	}

	public String findUserById(int userId) {
		try{
			  User user=userDao.findUserById(userId);
			  JSONObject jobj=new JSONObject();
			  jobj.put("userName", user.getUserName());
			  jobj.put("studentId", user.getUserName());
			  return jobj.toString();
			}
			catch(HibernateException e){
				e.printStackTrace();
				return null;		
			}
	}

	public int updateUser(User user) {
		try{
			  userDao.updateUser(user);
			}
			catch(HibernateException e){
				e.printStackTrace();
				return 0;		
			}
			return 1;	
	}

}
