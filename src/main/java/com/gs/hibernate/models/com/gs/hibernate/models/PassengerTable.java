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
 * PassengerTable generated by hbm2java
 */
@Entity
@Table(name = "passenger_table", schema = "public")
public class PassengerTable implements java.io.Serializable {

	private long seq;
	private int age;
	private String passengername;
	private Set<Ticket> tickets = new HashSet<Ticket>(0);

	public PassengerTable() {
	}

	public PassengerTable(long seq, int age) {
		this.seq = seq;
		this.age = age;
	}

	public PassengerTable(long seq, int age, String passengername, Set<Ticket> tickets) {
		this.seq = seq;
		this.age = age;
		this.passengername = passengername;
		this.tickets = tickets;
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

	@Column(name = "passengername")
	public String getPassengername() {
		return this.passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "passengerTable")
	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
