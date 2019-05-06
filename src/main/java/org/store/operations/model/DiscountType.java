package org.store.operations.model;

public class DiscountType {
	
	private String discountType;
	
	private String customerType;

	private Double percentage;

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public DiscountType(String discountType, String customerType, Double percentage) {
		super();
		this.discountType = discountType;
		this.customerType = customerType;
		this.percentage = percentage;
	}
	
	
}
