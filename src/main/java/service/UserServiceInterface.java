package service;

import java.util.List;

import model.UserModel;


public interface UserServiceInterface {
	
	public List<UserModel> listUsers();

	public UserModel findUserByUsername(String userName);
	
	public UserModel addUser(UserModel user);

	UserModel updateUser(UserModel user);

	void deleteUser(Long id);
}

