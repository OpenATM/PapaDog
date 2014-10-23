package domain.model;

import java.io.Serializable;

public class SalesItem extends BaseDTO{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private Float price;
    private Integer count;
    private Integer orderId;
    private Product_sec product_sec;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Product_sec getProduct_sec() {
		return product_sec;
	}
	public void setProduct_sec(Product_sec productSec) {
		product_sec = productSec;
	}
    

}
