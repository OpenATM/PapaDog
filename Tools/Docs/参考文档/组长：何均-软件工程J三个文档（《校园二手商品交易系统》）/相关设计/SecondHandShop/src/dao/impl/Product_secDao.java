package dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.hbm.HibernateUtils;
import dao.intef.IUserDao;
import domain.model.Product_sec;
import domain.model.User;

public class Product_secDao implements dao.intef.IProduct_secDao {

    private IUserDao userDao=new UserDao();
    
	public void addProduct(int userId, Product_sec productSec) {
          // TODO Auto-generated method stub
		Session s=null;
		Transaction tx=null;
		try{
			User user=userDao.findUserById(userId);
	      	
	        s=HibernateUtils.getSession();
	        tx=s.beginTransaction();
	        productSec.setUser(user);	
	        s.save(productSec);	         
	      
	        tx.commit();
		}finally{
			if(s!=null){
				s.close();
			}
		}

	}
	public Product_sec findProduct_secById(int product_secId) {
		Session s = null;
		Product_sec product_sec=null;
		try {
			
			s = HibernateUtils.getSession();
			product_sec = (Product_sec) s.get(Product_sec.class,new Integer(product_secId));
		}finally {
			if (s != null)
				s.close();
		}
		return product_sec;
	}


}
