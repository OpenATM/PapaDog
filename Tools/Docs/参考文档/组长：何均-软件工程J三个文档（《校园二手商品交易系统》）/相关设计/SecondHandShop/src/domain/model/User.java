package domain.model;

import java.util.HashSet;
import java.util.Set;

public class User extends BaseDTO{
 private Integer id;
 private String userName;
 private String password;
 private String realName;
 private String tel;
 private String studentId;
 private String room;
 private String description;
 private String school;

 private Set<Product_sec> product_secs=new HashSet<Product_sec>();
 

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRealName() {
	return realName;
}
public void setRealName(String realName) {
	this.realName = realName;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getStudentId() {
	return studentId;
}
public void setStudentId(String studentId) {
	this.studentId = studentId;
}
public String getRoom() {
	return room;
}
public void setRoom(String room) {
	this.room = room;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
public Set<Product_sec> getProduct_secs() {
	return product_secs;
}
public void setProduct_secs(Set<Product_sec> productSecs) {
	product_secs = productSecs;
} 

}
