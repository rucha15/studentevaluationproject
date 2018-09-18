package com.project.studentevaluationproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.studentevaluationproject.model.Login;


public interface LoginRepository extends JpaRepository<Login, Long> {
	
	@Query("SELECT l FROM Login l WHERE l.username = ?1")
	Login findByUsername(String username);
	
	@Query("DELETE FROM Login WHERE username = ?1")
	Login deleteByUsername(String username);
}
