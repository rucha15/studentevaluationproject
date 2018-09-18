package com.project.studentevaluationproject.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.studentevaluationproject.model.Student;
import com.project.studentevaluationproject.repository.StudentRepository;


@Service
public class StudentDAO {

	@Autowired
	public StudentRepository studentRepository;
	
	public Student save(Student student){
		return studentRepository.save(student);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public List<Student> findByEmail(String email){
		return studentRepository.findByEmail(email);
	}
	
	public Student deleteByEmail(String email){
		return studentRepository.deleteByEmail(email);
	}
}
