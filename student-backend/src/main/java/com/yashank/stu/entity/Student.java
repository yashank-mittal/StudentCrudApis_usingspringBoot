package com.yashank.stu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  //it shows it is a JPA entity
@Table(name="students") //used to specify the details for tables
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // automatically increase no. for id
	@Column(name = "Student_ID")
	private long id;
	@Column(name = "First_Name")
	private String firstName;
	@Column(name = "Last_Name")
	private String lastName;
	@Column(name = "Email_ID",nullable = false,unique = true)
	private String email;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student() {}
	
	public Student(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
}
