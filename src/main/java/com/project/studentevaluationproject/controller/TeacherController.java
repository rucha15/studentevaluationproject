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
import com.project.studentevaluationproject.dao.TeacherDAO;
import com.project.studentevaluationproject.model.Teacher;

@RestController  
@RequestMapping("/school")
public class TeacherController {

	@Autowired
	TeacherDAO teacherDAO;
	
	@PostMapping("/teacher")
	public Teacher createTeacher(@Valid @RequestBody Teacher t){
		return teacherDAO.save(t);
	}
	
	//get all teachers
	@GetMapping("/teachers")
	public List<Teacher> getAllTeachers(){
		return teacherDAO.findAll();
	}
		
	//get teacher by email
	@GetMapping("/teacher_by_email")
	public ResponseEntity<List<Teacher>> getTeacherByEmail(@PathVariable(value="email") String email){
		List<Teacher> t = teacherDAO.findByEmail(email);
		return ResponseEntity.ok().body(t);
	}
		
	//delete by email
	@DeleteMapping("/teacher_by_email")
	public ResponseEntity<Void> deleteTeacher(@PathVariable(value="email") String email){
		teacherDAO.deleteByEmail(email);
		return ResponseEntity.ok().build();
	}
}
