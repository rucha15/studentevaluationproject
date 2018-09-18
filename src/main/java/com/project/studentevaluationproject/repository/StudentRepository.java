package com.project.studentevaluationproject.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.project.studentevaluationproject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("SELECT s FROM Student s WHERE s.person.email = ?1")
	List<Student> findByEmail(String email);
	
	@Query("DELETE FROM Student s WHERE s.person.email = ?1")
	Student deleteByEmail(String email);
}
	