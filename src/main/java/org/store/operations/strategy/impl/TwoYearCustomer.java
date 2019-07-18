package org.store.operations.strategy.impl;

import org.store.operations.strategy.DiscountStrategy;

public class TwoYearCustomer implements DiscountStrategy {

	public static final Double DISCOUNT = 0.1;

	@Override
	public Double getDiscount(Double nonGroceryAmount, Double totalAmount) {
		return (nonGroceryAmount * DISCOUNT) + calculateCommonDiscount(totalAmount);
	}

}
