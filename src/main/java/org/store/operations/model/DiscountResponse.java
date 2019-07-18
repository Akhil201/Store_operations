package org.store.operations.model;

import java.io.Serializable;

public class DiscountResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 464564L;

	private Double totalAmount;
	
	private Double discountAmount;
	
	private Double netAmount;

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}
	
	
	
}
