package com.yashank.stu.mapper;

import com.yashank.stu.dto.StudentDto;
import com.yashank.stu.entity.Student;

// Used this class to map StudentDto to Student Entity
public class StudentMapper {
	
	public static StudentDto mapToStudentDto(Student student)
	{
		return new StudentDto(
				student.getId(),
				student.getFirstName(),
				student.getLastName(),
				student.getEmail()
		);
	}
	
	public static Student maptoStudent(StudentDto studentDto)
	{
		return new Student(
				studentDto.getId(),
				studentDto.getFirstName(),
				studentDto.getLastName(),
				studentDto.getEmail()
		);
	}
}
