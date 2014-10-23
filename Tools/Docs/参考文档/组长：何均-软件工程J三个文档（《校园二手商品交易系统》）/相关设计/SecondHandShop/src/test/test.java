package test;

import java.util.Iterator;
import java.util.Set;

import dao.impl.Product_secDao;
import dao.impl.SalesItemDao;
import dao.impl.UserDao;
import dao.intef.IProduct_secDao;
import dao.intef.ISalesItemDao;
import dao.intef.IUserDao;
import domain.model.Product_sec;
import domain.model.SalesItem;
import domain.model.User;
import exception.SecondHandShopException;

public class test {
public static void main(String[] args) throws SecondHandShopException{
IUserDao userDao=new UserDao();
//System.out.println(System.getProperty("classpath"));
User user=new User();
user.setStudentId("20081780");
user.setPassword("123456");
user.setUserName("hejun");
user.setTel("15983642221");

//userDao.addUser(user);
userDao.deleteUser(user);
IProduct_secDao pDao=new Product_secDao();

Product_sec p1=new Product_sec();
p1.setProduct_secName("cow");
p1.setDescription("要是业内都公认的好书，我要长期珍藏它，就像j2se那个《java核心技术》，或者像C++的那个《C++ primer》由于这方面的技术更新快，所以内容上要新（大概：如讲Struts至少要2.0以上吧，spring也得2.5以上，hibernate到少3.3以上");
pDao.addProduct(1, p1);


Product_sec p2=new Product_sec();
p2.setProduct_secName("co");
pDao.addProduct(1, p2);

SalesItem s=new SalesItem();
s.setCount(8);
s.setPrice(15.0f);
ISalesItemDao salesDao=new SalesItemDao();
salesDao.addSalesItem(2, s);

//userDao.deleteUser(userDao.findUserById(1));
/*
Set<Product_sec> set=(Set<Product_sec>) userDao.findAllProduct_sec(1);

Iterator<Product_sec> iter=set.iterator();
while(iter.hasNext()){
	Product_sec product=iter.next();
	System.out.println(product.getProduct_secName());
}
*/

}
}


