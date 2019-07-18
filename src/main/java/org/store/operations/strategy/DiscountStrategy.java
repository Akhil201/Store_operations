package org.store.operations.strategy;

public interface DiscountStrategy {
	
	Double getDiscount(Double nonGroceryAmount, Double totalAmount);
	
	default Integer calculateCommonDiscount(Double totalAmount) {
		return (totalAmount.intValue() / 100) * 5;
	}

}
