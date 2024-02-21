package com.yashank.stu.services;

import java.util.List;

import com.yashank.stu.dto.StudentDto;

public interface StudentService {
	StudentDto createStudent(StudentDto studentDto);
	StudentDto getStudentById(long studentId);
	List<StudentDto> getAllStudent();
	StudentDto updateStudent(long studentId,StudentDto updatedStudent);
	void deleteStudent(long studentId);
}
