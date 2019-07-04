package com.gs.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Passenger {

	@Id
	@GeneratedValue(generator = "passenger_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "passenger_gen", sequenceName = "passenger_seq", allocationSize = 1, initialValue = 1)
	private long seq;
	private String passengerName;
	private int age;

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
