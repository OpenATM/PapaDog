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
p1.setDescription("Ҫ��ҵ�ڶ����ϵĺ��飬��Ҫ���������������j2se�Ǹ���java���ļ�������������C++���Ǹ���C++ primer�������ⷽ��ļ������¿죬����������Ҫ�£���ţ��署Struts����Ҫ2.0���ϰɣ�springҲ��2.5���ϣ�hibernate����3.3����");
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


