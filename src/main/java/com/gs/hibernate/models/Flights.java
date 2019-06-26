package com.gs.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flights {

	@Id
	@Column(name="flight_id")
	private int flightId;
	@Column(name= "flight_name")
	private String flightName;

	public Flights() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flights(int flightId, String flightName) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	@Override
	public String toString() {
		return "Flights [flightId=" + flightId + ", flightName=" + flightName + "]";
	}

}
