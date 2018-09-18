package com.project.studentevaluationproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.studentevaluationproject.model.Teacher;



public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	@Query("SELECT t FROM Teacher t WHERE t.person.email = ?1")
	List<Teacher> findByEmail(String email);
	
	@Query("DELETE FROM Teacher t WHERE t.person.email = ?1")
	Teacher deleteByEmail(String email);
}