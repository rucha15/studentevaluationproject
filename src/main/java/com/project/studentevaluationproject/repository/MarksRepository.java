package com.project.studentevaluationproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.project.studentevaluationproject.model.Marks;

public interface MarksRepository extends JpaRepository<Marks, Long>{

	@Query("SELECT m FROM Marks m WHERE m.student.person.email = ?1 and m.grade = ?2")
	List<Marks> findByGrade(String email, int grade);
	
	
	@Query("SELECT m FROM Marks m WHERE m.student.person.first_name = ?1 and m.student.person.last_name = ?2")
	List<Marks> findByName(String first_name, String last_name);
	
	
	@Query("SELECT m FROM Marks m WHERE m.student.person.email = ?1 and m.subject_name = ?2")
	List<Marks> findBySubject(String email, String subject_name);
	

	@Query("SELECT m FROM Marks m WHERE m.student.person.email = ?1 and m.semester = ?2")
	List<Marks> findBySemester(String email, String semester);
	

	@Query("SELECT m FROM Marks m WHERE m.student.person.email = ?1 and m.subject_name = ?2 and m.grade = ?3 and m.semester = ?4")
	List<Marks> findByCustom(String email, String subject_name, int grade, String semester);
	

	@Query("DELETE FROM Marks m WHERE m.student.person.email = ?1")
	Marks deleteByEmail(String email);
	
}
