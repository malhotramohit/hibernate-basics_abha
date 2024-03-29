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
 * Categories generated by hbm2java
 */
@Entity
@Table(name = "categories", schema = "public")
public class Categories implements java.io.Serializable {

	private short categoryId;
	private String categoryName;
	private String description;
	private byte[] picture;
	private Set<Products> productses = new HashSet<Products>(0);

	public Categories() {
	}

	public Categories(short categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Categories(short categoryId, String categoryName, String description, byte[] picture,
			Set<Products> productses) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
		this.productses = productses;
	}

	@Id

	@Column(name = "category_id", unique = true, nullable = false)
	public short getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(short categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "category_name", nullable = false, length = 15)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "picture")
	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Products> getProductses() {
		return this.productses;
	}

	public void setProductses(Set<Products> productses) {
		this.productses = productses;
	}

}
