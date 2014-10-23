package domain.model;

public class Product_sec extends BaseDTO {
  private Integer id;
  private String product_secName;
  private String description;
  private Float price;
  private int categoryId;
  private User user;

  private SalesItem salesItem;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getProduct_secName() {
	return product_secName;
}
public void setProduct_secName(String product_secName) {
	this.product_secName = product_secName;
}
public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}
public Float getPrice() {
	return price;
}
public void setPrice(Float price) {
	this.price = price;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public SalesItem getSalesItem() {
	return salesItem;
}
public void setSalesItem(SalesItem salesItem) {
	this.salesItem = salesItem;
}
   
}
