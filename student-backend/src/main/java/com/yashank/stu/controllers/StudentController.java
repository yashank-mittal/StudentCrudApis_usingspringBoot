package com.yashank.stu.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yashank.stu.dto.StudentDto;
import com.yashank.stu.services.StudentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	//Build Add Student Rest Api
	@PostMapping
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto)//@requestbody : it extract the json from http request and convert it into studentDTo
	{
		StudentDto savedStudent = studentService.createStudent(studentDto);
		return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
	}
	
	// Build Get Student Rest api
	@GetMapping("{id}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") long studentId)
	{
		StudentDto studentDto = studentService.getStudentById(studentId);
		return ResponseEntity.ok(studentDto);
	}
	
	//Build Get All Student Rest Api
	@GetMapping
	public ResponseEntity<List<StudentDto>> getAllStudents()
	{
		List<StudentDto> students = studentService.getAllStudent();
		return ResponseEntity.ok(students);
	}
	
	//Build Updated Student Rest Api
	@PutMapping("{id}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") long studentId,@RequestBody StudentDto updatedStudent)
	{
		StudentDto studentDto=studentService.updateStudent(studentId, updatedStudent);
		return ResponseEntity.ok(studentDto);
	}
	
	//Build Delete Student Rest Api
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long studentId)
	{
		studentService.deleteStudent(studentId);
		return ResponseEntity.ok("Given Student Deleted Successfully");
	}

}
