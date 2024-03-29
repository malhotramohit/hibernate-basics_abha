package com.gs.hibernate.models;
// Generated 19 Jul, 2019 8:29:04 PM by Hibernate Tools 5.2.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customers generated by hbm2java
 */
@Entity
@Table(name = "customers", schema = "public")
public class Customers implements java.io.Serializable {

	private String customerId;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;
	private String city;
	private String region;
	private String postalCode;
	private String country;
	private String phone;
	private String fax;
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<CustomerDemographics> customerDemographicses = new HashSet<CustomerDemographics>(0);

	public Customers() {
	}

	public Customers(String customerId, String companyName) {
		this.customerId = customerId;
		this.companyName = companyName;
	}

	public Customers(String customerId, String companyName, String contactName, String contactTitle, String address,
			String city, String region, String postalCode, String country, String phone, String fax,
			Set<Orders> orderses, Set<CustomerDemographics> customerDemographicses) {
		this.customerId = customerId;
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
		this.phone = phone;
		this.fax = fax;
		this.orderses = orderses;
		this.customerDemographicses = customerDemographicses;
	}

	@Id

	@Column(name = "customer_id", unique = true, nullable = false)
	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column(name = "company_name", nullable = false, length = 40)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "contact_name", length = 30)
	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "contact_title", length = 30)
	public String getContactTitle() {
		return this.contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
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

	@Column(name = "phone", length = 24)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "fax", length = 24)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "customer_customer_demo", schema = "public", joinColumns = {
			@JoinColumn(name = "customer_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "customer_type_id", nullable = false, updatable = false) })
	public Set<CustomerDemographics> getCustomerDemographicses() {
		return this.customerDemographicses;
	}

	public void setCustomerDemographicses(Set<CustomerDemographics> customerDemographicses) {
		this.customerDemographicses = customerDemographicses;
	}

}
