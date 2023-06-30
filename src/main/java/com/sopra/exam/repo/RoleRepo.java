package com.sopra.exam.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.exam.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
