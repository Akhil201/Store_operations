package org.store.operations.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.store.operations.model.Customer;
import org.store.operations.util.ApiConstants;
import org.store.operations.util.Utility;

public class TestCustomerDiscount extends DiscountTypes {

	
	@Autowired
	private DiscountStrategy discountStrategy;
	
	
	@Test
	public void testAfflicatedCustomerDiscount() {
		loadDiscountTypes();
		Customer customer = new Customer("FCHGFSAYU", ApiConstants.AFFILIATED, Utility.getDateTimeonPeriod(-3),"Sultan");
		assertEquals(ApiConstants.AFFILIATED, discountStrategy.getDiscountStrategy(customer).getDiscountType());
	}
	
	@Test
	public void testEmployeeCustomerDiscount() {
		loadDiscountTypes();
		Customer customer = new Customer("DUBIINV", ApiConstants.EMPLOYEE, Utility.getDateTimeonPeriod(-3),"Sultan");
		assertEquals(ApiConstants.EMPLOYEE, discountStrategy.getDiscountStrategy(customer).getDiscountType());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGeneralCustomerDiscount() {
		loadDiscountTypes();
		Customer customer = new Customer("TBGJJGVFF", ApiConstants.GENERAL, Utility.getDateTimeonPeriod(-1),"Sultan");
		fail(discountStrategy.getDiscountStrategy(customer).getDiscountType());
	}
	
	@Test
	public void testTwoYearOldCustomerDiscount() {
		loadDiscountTypes();
		Customer customer = new Customer("POIUUYTFRV", ApiConstants.GENERAL, Utility.getDateTimeonPeriod(-3),"Sultan");
		assertEquals(ApiConstants.TWO_YEAR_USER_DISCOUNT, discountStrategy.getDiscountStrategy(customer).getDiscountType());
	}


	
	
}
