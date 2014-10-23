package dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.hbm.HibernateUtils;
import dao.intef.IProduct_secDao;
import dao.intef.ISalesItemDao;
import domain.model.Product_sec;
import domain.model.SalesItem;

public class SalesItemDao implements ISalesItemDao {
    IProduct_secDao product_secDao=new Product_secDao();
	public void addSalesItem(int product_secId, SalesItem salesItem) {
	   Session s=null;
	   Transaction tx=null;
	   try{
	   Product_sec product_sec=product_secDao.findProduct_secById(product_secId);
	   
	   s=HibernateUtils.getSession();
	   tx=s.beginTransaction();
        
	   product_sec.setSalesItem(salesItem);
	   salesItem.setProduct_sec(product_sec);
	   s.update(product_sec);
	   
	   tx.commit();
   
	   }finally{
		if(s!=null){
			s.close();
		}
	   }
	}

}
