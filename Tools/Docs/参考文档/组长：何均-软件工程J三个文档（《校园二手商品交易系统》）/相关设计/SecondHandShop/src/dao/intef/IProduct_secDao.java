package dao.intef;

import domain.model.Product_sec;

public interface IProduct_secDao {
	/**
	 *�����û�ID��Ӷ��ֻ��� 
	 * @param userId �û�ID
	 * @param product_sec ���룻
	 */
   public void addProduct(int userId,Product_sec product_sec);
   
   public Product_sec findProduct_secById(int product_secId);
}
