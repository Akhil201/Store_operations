package org.store.operations.service;

import org.store.operations.model.Customer;
import org.store.operations.model.DiscountModel;

public interface DiscountStrategy {

	public void setDiscountStrategy(DiscountModel discountType);

	public DiscountModel getDiscountStrategy(Customer customer);
}
