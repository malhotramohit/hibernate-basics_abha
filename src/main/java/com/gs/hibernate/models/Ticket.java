package com.gs.hibernate.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(generator = "ticket_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ticket_gen", sequenceName = "ticket_seq", initialValue = 1, allocationSize = 1)
	private long seq;
	// ticket_name
	@Column(name = "ticket_name")
	private String ticketName;
	private double price;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pass_id")
	private Passenger passesnger;

	// @OneToOne
	// @JoinColumn(name = "passenger_id")
	// private Passenger passenger;

	public Passenger getPassesnger() {
		return passesnger;
	}

	public void setPassesnger(Passenger passesnger) {
		this.passesnger = passesnger;
	}

	@Transient
	private Date date;

	@Temporal(TemporalType.DATE)
	private Date date2;

	@Temporal(TemporalType.TIME)
	private Date date3;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date4;

	public Ticket() {
		super();
	}

	public Ticket(String ticketName, double price) {

		this.ticketName = ticketName;
		this.price = price;
	}

	public Ticket(String ticketName, double price, Date date) {

		this.ticketName = ticketName;
		this.price = price;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	public Date getDate4() {
		return date4;
	}

	public void setDate4(Date date4) {
		this.date4 = date4;
	}

	// public Passenger getPassenger() {
	// return passenger;
	// }
	//
	// public void setPassenger(Passenger passenger) {
	// this.passenger = passenger;
	// }

	@Override
	public String toString() {
		return "Ticket [seq=" + seq + ", ticketName=" + ticketName + ", price=" + price + ", date=" + date + ", date2="
				+ date2 + ", date3=" + date3 + ", date4=" + date4 + "]";
	}

}
