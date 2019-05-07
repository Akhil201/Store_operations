package org.store.operations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.store.operations.StoreOperationsApplicationTests;
import org.store.operations.model.DiscountModel;
import org.store.operations.util.ApiConstants;

public class DiscountTypes extends StoreOperationsApplicationTests {
	
	@Autowired
	DiscountStrategy discountStrategy;
	
	public void loadDiscountTypes() {
	
		DiscountModel discount1 = new DiscountModel(ApiConstants.TWO_YEAR_USER_DISCOUNT, ApiConstants.GENERAL, 5.0);
		DiscountModel discount2 = new DiscountModel(ApiConstants.AFFILIATED, ApiConstants.AFFILIATED, 10.0);
		DiscountModel discount3 = new DiscountModel(ApiConstants.EMPLOYEE, ApiConstants.EMPLOYEE, 30.0);
		
		discountStrategy.setDiscountStrategy(discount1);
		discountStrategy.setDiscountStrategy(discount2);
		discountStrategy.setDiscountStrategy(discount3);
	}

}
