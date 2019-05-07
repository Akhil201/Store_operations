package org.store.operations.model;

public class DiscountModel {
	
	private String discountType;
	
	private String customerType;

	private Double percentage;

	public String getDiscountType() {
		return discountType;
	}


	public String getCustomerType() {
		return customerType;
	}

	public Double getPercentage() {
		return percentage;
	}

	public DiscountModel(String discountType, String customerType, Double percentage) {
		super();
		this.discountType = discountType;
		this.customerType = customerType;
		this.percentage = percentage;
	}
	
	
}
