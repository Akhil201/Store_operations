package org.store.operations.strategy.impl;

import org.store.operations.strategy.DiscountStrategy;

public class EmployeeCustomer implements DiscountStrategy {

	public static final Double DISCOUNT = 0.3;

	@Override
	public Double getDiscount(Double nonGroceryAmount, Double totalAmount) {
		return (nonGroceryAmount * DISCOUNT) + calculateCommonDiscount(totalAmount);
	}

}
