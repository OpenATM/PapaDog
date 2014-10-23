package dao.intef;

import domain.model.Product_sec;

public interface IProduct_secDao {
	/**
	 *根据用户ID添加二手货； 
	 * @param userId 用户ID
	 * @param product_sec 密码；
	 */
   public void addProduct(int userId,Product_sec product_sec);
   
   public Product_sec findProduct_secById(int product_secId);
}
