package org.store.operations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.store.operations.StoreOperationsApplicationTests;
import org.store.operations.model.DiscountType;
import org.store.operations.util.ApiConstants;

public class DiscountTypes extends StoreOperationsApplicationTests {
	
	@Autowired
	DiscountStrategy discountStrategy;
	
	public void loadDiscountTypes() {
	
		DiscountType discount1 = new DiscountType(ApiConstants.TWO_YEAR_USER_DISCOUNT, ApiConstants.GENERAL, 5.0);
		DiscountType discount2 = new DiscountType(ApiConstants.AFFILIATED, ApiConstants.AFFILIATED, 10.0);
		DiscountType discount3 = new DiscountType(ApiConstants.EMPLOYEE, ApiConstants.EMPLOYEE, 30.0);
		
		discountStrategy.setDiscountStrategy(discount1);
		discountStrategy.setDiscountStrategy(discount2);
		discountStrategy.setDiscountStrategy(discount3);
	}

}
