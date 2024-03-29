package com.gs.hibernate.models;
// Generated 19 Jul, 2019 8:29:04 PM by Hibernate Tools 5.2.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Employees generated by hbm2java
 */
@Entity
@Table(name = "employees", schema = "public")
public class Employees implements java.io.Serializable {

	private short employeeId;
	private Employees employees;
	private String lastName;
	private String firstName;
	private String title;
	private String titleOfCourtesy;
	private Date birthDate;
	private Date hireDate;
	private String address;
	private String city;
	private String region;
	private String postalCode;
	private String country;
	private String homePhone;
	private String extension;
	private byte[] photo;
	private String notes;
	private String photoPath;
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Territories> territorieses = new HashSet<Territories>(0);
	private Set<Employees> employeeses = new HashSet<Employees>(0);

	public Employees() {
	}

	public Employees(short employeeId, String lastName, String firstName) {
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public Employees(short employeeId, Employees employees, String lastName, String firstName, String title,
			String titleOfCourtesy, Date birthDate, Date hireDate, String address, String city, String region,
			String postalCode, String country, String homePhone, String extension, byte[] photo, String notes,
			String photoPath, Set<Orders> orderses, Set<Territories> territorieses, Set<Employees> employeeses) {
		this.employeeId = employeeId;
		this.employees = employees;
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
		this.titleOfCourtesy = titleOfCourtesy;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
		this.homePhone = homePhone;
		this.extension = extension;
		this.photo = photo;
		this.notes = notes;
		this.photoPath = photoPath;
		this.orderses = orderses;
		this.territorieses = territorieses;
		this.employeeses = employeeses;
	}

	@Id

	@Column(name = "employee_id", unique = true, nullable = false)
	public short getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(short employeeId) {
		this.employeeId = employeeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reports_to")
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@Column(name = "last_name", nullable = false, length = 20)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "first_name", nullable = false, length = 10)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "title", length = 30)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "title_of_courtesy", length = 25)
	public String getTitleOfCourtesy() {
		return this.titleOfCourtesy;
	}

	public void setTitleOfCourtesy(String titleOfCourtesy) {
		this.titleOfCourtesy = titleOfCourtesy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", length = 13)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "hire_date", length = 13)
	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Column(name = "address", length = 60)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city", length = 15)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "region", length = 15)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "postal_code", length = 10)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "country", length = 15)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "home_phone", length = 24)
	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@Column(name = "extension", length = 4)
	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Column(name = "photo")
	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Column(name = "notes")
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "photo_path")
	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employees")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "employee_territories", schema = "public", joinColumns = {
			@JoinColumn(name = "employee_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "territory_id", nullable = false, updatable = false) })
	public Set<Territories> getTerritorieses() {
		return this.territorieses;
	}

	public void setTerritorieses(Set<Territories> territorieses) {
		this.territorieses = territorieses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employees")
	public Set<Employees> getEmployeeses() {
		return this.employeeses;
	}

	public void setEmployeeses(Set<Employees> employeeses) {
		this.employeeses = employeeses;
	}

}
