package com.sopra.exam.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.exam.entity.Role;
import com.sopra.exam.entity.User;
import com.sopra.exam.entity.UserRole;
import com.sopra.exam.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/test")
	public String test() {
		return "Welcome to backend api of Examportal";
	}
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception  {
		
		
		user.setProfile("default.png");
		//encoding password with bcryptpasswordencode 
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		
		Set<UserRole> roles=new HashSet<>();
		
		Role role=new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		User createUser = this.userService.createUser(user, roles);
		
		return createUser;
	}
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		List<User> allUser = this.userService.allUser();
		return allUser;
	}
	
	
	@GetMapping("/{username}")
	public User getUserByUsername(@PathVariable String username) {
		User userByUsername = this.userService.getUserByUsername(username);
		return userByUsername;
				
	}
	@DeleteMapping("/{username}")
	public void deleteUser(@PathVariable String username) {
		this.userService.deleteUser(username);
	}

}
