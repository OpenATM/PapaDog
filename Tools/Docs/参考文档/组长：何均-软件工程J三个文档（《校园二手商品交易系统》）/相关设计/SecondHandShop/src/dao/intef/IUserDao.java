package dao.intef;

import java.util.Set;

import domain.model.Product_sec;
import domain.model.User;
import exception.SecondHandShopException;

public interface IUserDao {
public void addUser(User user) throws SecondHandShopException;
public User findUserById(int userId);
public void updateUser(User user);
public void deleteUser(User user) throws SecondHandShopException;
public Set<Product_sec> findAllProduct_sec(int userId);
}
