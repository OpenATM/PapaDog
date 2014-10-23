package dao.intef;

import domain.model.SalesItem;

public interface ISalesItemDao {
	public void addSalesItem(int product_secId,SalesItem salesItem);
}
