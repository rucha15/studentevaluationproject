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


import com.project.studentevaluationproject.dao.MarksDAO;
import com.project.studentevaluationproject.model.Marks;

@RestController  
@RequestMapping("/school")
public class MarksController {
	
	@Autowired
	MarksDAO marksDAO;
	
	
	@PostMapping("/marks")
	public Marks createMarks(@Valid @RequestBody Marks m){
		return marksDAO.save(m);
	}
	
	//get all marks
	@GetMapping("/marks")
	public List<Marks> getAllMarks(){
		return marksDAO.findAll();
	}

	//get marks by email, grade
	@GetMapping("/marks_by_email_and_grade")
	public ResponseEntity<List<Marks>> getMarksByEmailAndGrade(@PathVariable(value="email") String email, @PathVariable(value="grade") int grade){
		List<Marks> m = marksDAO.findByGrade(email, grade);
		return ResponseEntity.ok().body(m);
	}
		
	//get marks by name
	@GetMapping("/marks_by_name")
	public ResponseEntity<List<Marks>> getMarksByName(@PathVariable(value="first_name") String first_name, @PathVariable(value="last_name") String last_name){
		List<Marks> m = marksDAO.findByName(first_name, last_name);
		return ResponseEntity.ok().body(m);
	}
			
	//get marks by subject
	@GetMapping("/marks_by_subject")
	public ResponseEntity<List<Marks>> getMarksBySubject(@PathVariable(value="email") String email, @PathVariable(value="subject_name") String subject_name){
		List<Marks> m = marksDAO.findBySubject(email, subject_name);
		return ResponseEntity.ok().body(m);
	}
		
	//get marks by semester
	@GetMapping("/marks_by_semester")
	public ResponseEntity<List<Marks>> getMarksBySemester(@PathVariable(value="email") String email, @PathVariable(value="semester") String semester){
		List<Marks> m = marksDAO.findBySemester(email, semester);
		return ResponseEntity.ok().body(m);
	}
		
	//get marks by custom
	@GetMapping("/marks_by_customer")
	public ResponseEntity<List<Marks>> getMarksByCustom(@PathVariable(value="email") String email, @PathVariable(value="subject_name") String subject_name, @PathVariable(value="grade") int grade, @PathVariable(value="semester") String semester){
		List<Marks> m = marksDAO.findByCustom(email, subject_name, grade, semester);
		return ResponseEntity.ok().body(m);
	}
		
	//delete by email
	@DeleteMapping("/marks_by_email")
	public ResponseEntity<Void> deleteMarks(@PathVariable(value="email") String email){
		marksDAO.deleteByEmail(email);
		return ResponseEntity.ok().build();
	}
}
