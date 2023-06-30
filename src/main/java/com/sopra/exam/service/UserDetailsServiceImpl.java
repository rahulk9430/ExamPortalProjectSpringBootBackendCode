package com.sopra.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sopra.exam.entity.User;
import com.sopra.exam.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User findByUsername = this.userRepo.findByUsername(username);
		if(findByUsername==null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("No User Found");
		}
		return findByUsername;
		}
	
	

}
