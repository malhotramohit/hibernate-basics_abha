package com.gs.hibernate.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
		@NamedQuery(name = "Passenger.getPassengerByAge", query = "select pa from passenger pa where pa.age = :age "),
		@NamedQuery(name = "Passenger.getPassengerByName",query = "select pa from passenger pa where pa.passengerName = :passengerName ")
		})

@Entity(name="passenger")
@Table(name = "passenger_table")
public class Passenger {

	@Id
	@GeneratedValue(generator = "passenger_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "passenger_gen", sequenceName = "passenger_seq", allocationSize = 1, initialValue = 1)
	private long seq;
	private String passengerName;
	private int age;

	@OneToMany(mappedBy = "passesnger", cascade = CascadeType.ALL)
	// @JoinTable(name = "passenger_ticket_xref", joinColumns = @JoinColumn(name =
	// "pass_id"), inverseJoinColumns = @JoinColumn(name = "tick_id"))
	private List<Ticket> tickets;

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(String passengerName, int age) {
		super();
		this.passengerName = passengerName;
		this.age = age;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Passenger [seq=" + seq + ", passengerName=" + passengerName + ", age=" + age + "]";
	}

}
