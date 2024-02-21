package com.yashank.stu.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yashank.stu.dto.StudentDto;
import com.yashank.stu.entity.Student;
import com.yashank.stu.exception.ResourceNotFoundException;
import com.yashank.stu.mapper.StudentMapper;
import com.yashank.stu.repository.StudentRepository;
import com.yashank.stu.services.StudentService;

import lombok.AllArgsConstructor;

@Service  //Tells Spring cotainer to create spring beans for this class
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		// TODO Auto-generated method stub
		//Convert StudentDTo to Student JPA Entity
		Student student = StudentMapper.maptoStudent(studentDto);
		//Save Student JPA entity to Database
		Student savedStudent = studentRepository.save(student);
		
		return StudentMapper.mapToStudentDto(savedStudent);
	}

	@Override
	public StudentDto getStudentById(long studentId) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(studentId)
		 .orElseThrow(() -> new ResourceNotFoundException("Student Not found with the given ID : "+studentId));
		
		
		return StudentMapper.mapToStudentDto(student);
	}

	@Override
	public List<StudentDto> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepository.findAll();
		return students.stream().map((student) -> StudentMapper.mapToStudentDto(student) )
				.collect(Collectors.toList());
	}

	@Override
	public StudentDto updateStudent(long studentId, StudentDto updatedStudent) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(studentId).orElseThrow(
				() -> new ResourceNotFoundException("Student is not found with the given ID : "+studentId)
		);
		
		student.setFirstName(updatedStudent.getFirstName());
		student.setLastName(updatedStudent.getLastName());
		student.setEmail(updatedStudent.getEmail());
		
		// Note : If student has ID then it gets updated else insert new object
		Student updatedStudentObj=studentRepository.save(student);
	
		return StudentMapper.mapToStudentDto(updatedStudentObj);
	}

	@Override
	public void deleteStudent(long studentId) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(studentId).orElseThrow(
				() -> new ResourceNotFoundException("Student is not found with the given ID : "+studentId)
		);
		
		studentRepository.deleteById(studentId);
	}

	

}
