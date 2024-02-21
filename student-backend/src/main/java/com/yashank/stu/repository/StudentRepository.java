package com.yashank.stu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashank.stu.entity.Student;


//when we extends jparepo we use to create crud operation on studentrepo
// Note JpaRepo is an interface which inplements the CRUD functions

public interface StudentRepository extends JpaRepository<Student, Long> {

}
