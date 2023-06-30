package com.sopra.exam.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.exam.entity.User;
import com.sopra.exam.entity.UserRole;
import com.sopra.exam.repo.RoleRepo;
import com.sopra.exam.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User findByUserName = this.userRepo.findByUsername(user.getUsername());
		if(findByUserName!=null) {
			System.out.println("User already Exist");
			throw new Exception("User Already Exist");
		}
		else {
			//create User
			
			//get one by one role in table
			for(UserRole ur:userRoles ) {
				roleRepo.save(ur.getRole());
			}
			//assign  all role  in user
			user.getUserRoles().addAll(userRoles);
			
			//save user and userRole
			findByUserName = this.userRepo.save(user);
		}
		
		return findByUserName;
	}

	@Override
	public List<User> allUser() {
		List<User> findAll = this.userRepo.findAll();
		return findAll;
	}


	@Override
	public User getUserByUsername(String usernname) {
		User findByUsername = this.userRepo.findByUsername(usernname);
		return findByUsername;
	}

	@Override
	public void deleteUser(String username) {
		User findByUsername = this.userRepo.findByUsername(username);
		
		this.userRepo.delete(findByUsername);
		
	}
	
	
	

}
