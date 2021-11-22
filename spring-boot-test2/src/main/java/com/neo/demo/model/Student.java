package com.neo.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentsData")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stid;
	@Column(name = "Student_name" , nullable = false)
	private String stname;
	@Column(name = "subject" , nullable = false)
	private String subject;
	@Column(name = "marks" , nullable = false)
	private int marks;
	public Student(long stid, String stname, String subject, int marks) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.subject = subject;
		this.marks = marks;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public long getStid() {
		return stid;
	}
	public void setStid(long id) {
		this.stid = id;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
}
