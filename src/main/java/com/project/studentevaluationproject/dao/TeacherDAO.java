package com.project.studentevaluationproject.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.studentevaluationproject.model.Teacher;
import com.project.studentevaluationproject.repository.TeacherRepository;

@Service
public class TeacherDAO {

	@Autowired
	public TeacherRepository teacherRepository;
	
	public Teacher save(Teacher teacher){
		return teacherRepository.save(teacher);
	}
	
	public List<Teacher> findAll(){
		return teacherRepository.findAll();
	}
	
	public List<Teacher> findByEmail(String email){
		return teacherRepository.findByEmail(email);
	}
	
	public Teacher deleteByEmail(String email){
		return teacherRepository.deleteByEmail(email);
	}
}
