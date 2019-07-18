package com.gs.hibernate.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long seq;
	private String teacherName;
	private int age;
	
	
@ManyToMany
	private List<Standard> standards;
	
	

	public List<Standard> getStandards() {
		return standards;
	}

	public void setStandards(List<Standard> standards) {
		this.standards = standards;
	}

	public Teacher() {
		super();
	}

	public Teacher(String teacherName, int age) {
		super();
		this.teacherName = teacherName;
		this.age = age;
	}

	public Teacher(long seq, String teacherName, int age) {
		super();
		this.seq = seq;
		this.teacherName = teacherName;
		this.age = age;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
