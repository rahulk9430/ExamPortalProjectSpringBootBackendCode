package com.sopra.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.exam.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUsername(String username);

}
