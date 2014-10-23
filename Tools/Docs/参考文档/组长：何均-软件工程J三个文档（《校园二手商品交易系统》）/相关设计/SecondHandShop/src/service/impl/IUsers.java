package service.impl;

import domain.model.User;

public interface IUsers {
	public int addUser(User user);
	public int delUser(User user);
	public int updateUser(User user);
	public String findUserById(int userId);
}
