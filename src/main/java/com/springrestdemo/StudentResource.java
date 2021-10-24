package com.springrestdemo;

import java.util.LinkedList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("springrest")
public class StudentResource {
	
	@Autowired
	StudentRepo studentRepo;
	
	@RequestMapping("students")
	public List<Student> getStudents(){
		
		List<Student> students = (List<Student>) studentRepo.findAll();
		
//		Student s1 = new Student();
//		s1.setId(101);
//		s1.setName("kartik");
//		s1.setPoints(200);
//		
//		students.add(s1);
		
		return students;
		
	}
	
	@RequestMapping("getstudent/{id}")
	public Student getStudent(@PathVariable("id")int id) {
		List<Student> students = (List<Student>) studentRepo.findAll();
		if(studentRepo.existsById(id)) {
			for (Student student : students) {
				if(student.getId() == id) {
					return student;
				}
			}
		}
		return new Student();		
	}
	
	@PostMapping(value = "addstudent",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudent(@RequestBody Student s) {
		studentRepo.save(s);
		return s;		
	}
	
	@DeleteMapping("deletestudent/{id}")
	public void deleteStudent(@PathVariable("id")int id) {
		List<Student> students = (List<Student>) studentRepo.findAll();
		if(studentRepo.existsById(id)) {
			for (Student student : students) {
				if(student.getId() == id) {
					studentRepo.delete(student);
					break;
				}
			}
		}
		
		
	}
	
}
