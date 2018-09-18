package com.project.studentevaluationproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.studentevaluationproject.dao.StudentDAO;

import com.project.studentevaluationproject.model.Student;

@RestController  
@RequestMapping("/school")
public class StudentController {
	
	@Autowired
	StudentDAO studentDAO;
	
	@PostMapping("/student")
	public Student createStudent(@Valid @RequestBody Student s){
		return studentDAO.save(s);
	}
	
	//get all students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentDAO.findAll();
	}
	
	//get studnet by email
	@GetMapping("/student_by_email")
	public ResponseEntity<List<Student>> getStudentByEmail(@PathVariable(value="email") String email){
		List<Student> s = studentDAO.findByEmail(email);
		return ResponseEntity.ok().body(s);
	}
	
	//delete by email
	@DeleteMapping("/student")
	public ResponseEntity<Void> deleteStudent(@PathVariable(value="email") String email){
		studentDAO.deleteByEmail(email);
		return ResponseEntity.ok().build();
	}
}
