package com.gs.hibernate.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Standard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long seq;
	private String sName;
	private int numOfStundents;

	@ManyToMany(mappedBy="standards")
	private List<Teacher> teachers;

	public Standard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Standard(String sName, int numOfStundents) {
		super();
		this.sName = sName;
		this.numOfStundents = numOfStundents;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getNumOfStundents() {
		return numOfStundents;
	}

	public void setNumOfStundents(int numOfStundents) {
		this.numOfStundents = numOfStundents;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

}
