package dao.impl;

import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.hbm.BaseDAO;
import dao.hbm.HibernateUtils;
import dao.intef.IUserDao;
import domain.model.Product_sec;
import domain.model.User;
import exception.SecondHandShopException;

public class UserDao implements IUserDao {
	public void addUser(User user) throws SecondHandShopException {
		/*
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtils.getSession();
			tx = s.beginTransaction();
			s.save(user);
			tx.commit();
		}catch(HibernateException e){
			throw e;
		}
		finally {
			if (s != null)
				s.close();
		}*/
			BaseDAO.getBaseDAO().addObject(user);

	}

	public void deleteUser(User user) throws SecondHandShopException   {
            BaseDAO.getBaseDAO().deleteObject(user);
	}

	public User findUserById(int userId) {
		Session s = null;
		User user = null;
		try {
			
			s = HibernateUtils.getSession();
			System.out.println(s);
			user = (User) s.get(User.class,new Integer(userId));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (s != null)
				s.close();
		}
		return user;
	}

	public void updateUser(User user) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtils.getSession();
			tx = s.beginTransaction();
			s.update(user);
			tx.commit();
		} finally {
			if (s != null)
				s.close();
		}
	}
	public Set<Product_sec> findAllProduct_sec(int userId){
		Session s = null;
        User user=null;
				try {			
	        s = HibernateUtils.getSession();
			user = (User) s.get(User.class,new Integer(userId));
			
	     	Hibernate.initialize(user.getProduct_secs());
	
	//		System.out.println("user:"+user.getProduct_secs().size());
			return user.getProduct_secs();
				}
		finally {
			if (s != null)
				s.close();
		}
	
	}

}
