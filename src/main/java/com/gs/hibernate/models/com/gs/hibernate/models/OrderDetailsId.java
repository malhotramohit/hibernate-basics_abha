package com.gs.hibernate.models;
// Generated 19 Jul, 2019 8:29:04 PM by Hibernate Tools 5.2.10.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderDetailsId generated by hbm2java
 */
@Embeddable
public class OrderDetailsId implements java.io.Serializable {

	private short orderId;
	private short productId;

	public OrderDetailsId() {
	}

	public OrderDetailsId(short orderId, short productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

	@Column(name = "order_id", nullable = false)
	public short getOrderId() {
		return this.orderId;
	}

	public void setOrderId(short orderId) {
		this.orderId = orderId;
	}

	@Column(name = "product_id", nullable = false)
	public short getProductId() {
		return this.productId;
	}

	public void setProductId(short productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderDetailsId))
			return false;
		OrderDetailsId castOther = (OrderDetailsId) other;

		return (this.getOrderId() == castOther.getOrderId()) && (this.getProductId() == castOther.getProductId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOrderId();
		result = 37 * result + this.getProductId();
		return result;
	}

}
