package com.sopra.exam.service;

import java.util.List;
import java.util.Set;

import com.sopra.exam.entity.User;
import com.sopra.exam.entity.UserRole;

public interface UserService {
	
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	public List<User> allUser();
	
	
	public User getUserByUsername(String usernname);
	
	public void deleteUser(String username);

}
