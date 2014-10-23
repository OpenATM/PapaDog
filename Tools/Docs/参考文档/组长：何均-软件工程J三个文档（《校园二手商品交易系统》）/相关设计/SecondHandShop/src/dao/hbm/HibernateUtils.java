package dao.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public final class HibernateUtils {
   private static SessionFactory sessionFactory;
   private HibernateUtils(){	   
   }
   static{	   
   Configuration cfg=new Configuration(); 
   cfg.configure();
   
   sessionFactory=cfg.buildSessionFactory();
   }
   public static SessionFactory getSessionFactory() {
	return sessionFactory;
   }
   public static Session getSession() {
	   Session s = null;
	   try{
		  s = sessionFactory.openSession();
		  // s=sessionFactory.getCurrentSession();
	   }catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return s;
   }
   public static int test(){
	   return 4;
   }
}
