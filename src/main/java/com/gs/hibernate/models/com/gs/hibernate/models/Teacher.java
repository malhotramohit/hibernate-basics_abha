package com.gs.hibernate.models;
// Generated 19 Jul, 2019 8:29:04 PM by Hibernate Tools 5.2.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Teacher generated by hbm2java
 */
@Entity
@Table(name = "teacher", schema = "public")
public class Teacher implements java.io.Serializable {

	private long seq;
	private int age;
	private String teachername;
	private Set<TeacherStandard> teacherStandards = new HashSet<TeacherStandard>(0);

	public Teacher() {
	}

	public Teacher(long seq, int age) {
		this.seq = seq;
		this.age = age;
	}

	public Teacher(long seq, int age, String teachername, Set<TeacherStandard> teacherStandards) {
		this.seq = seq;
		this.age = age;
		this.teachername = teachername;
		this.teacherStandards = teacherStandards;
	}

	@Id

	@Column(name = "seq", unique = true, nullable = false)
	public long getSeq() {
		return this.seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	@Column(name = "age", nullable = false)
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "teachername")
	public String getTeachername() {
		return this.teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
	public Set<TeacherStandard> getTeacherStandards() {
		return this.teacherStandards;
	}

	public void setTeacherStandards(Set<TeacherStandard> teacherStandards) {
		this.teacherStandards = teacherStandards;
	}

}
