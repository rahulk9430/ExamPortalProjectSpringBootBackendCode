package com.sopra.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.exam.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
