package org.store.operations.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.store.operations.model.BillItem;
import org.store.operations.model.StoreCustomer;
import org.store.operations.util.ApiConstants;
import org.store.operations.util.Utility;

public class TestGeneralCustomer extends DiscountTypes {

	
	@Autowired
	private StoreService storeService;
	
	
	@Test
	public void testGeneralCustomerGroceryDiscount() {
		loadDiscountTypes();
		StoreCustomer customer = new StoreCustomer("YTHGNBKJIU", ApiConstants.GENERAL, Utility.getDateTimeonPeriod(-1),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("spices",29.0,"grocery"));
		items.add(new BillItem("chilly",29.0,"grocery"));
		items.add(new BillItem("Rice",129.0,"grocery"));
		
		assertEquals(182.0, storeService.calculateDiscount(items, customer),0.0);
	}
	
	
	@Test
	public void testGeneralCustomerNotGroceryDiscount() {
		loadDiscountTypes();
		StoreCustomer customer = new StoreCustomer("YTHGNBKJIU", ApiConstants.GENERAL, Utility.getDateTimeonPeriod(-1),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics"));
		items.add(new BillItem("ctype-cables",329.0,"electronics"));
		items.add(new BillItem("mobilecover",129.0,"electronics"));
		
		assertEquals(657.0, storeService.calculateDiscount(items, customer),0.0);
	}
	
	@Test
	public void testGeneralCustomerDiscount() {
		loadDiscountTypes();
		StoreCustomer customer = new StoreCustomer("YTHGNBKJIU", ApiConstants.GENERAL, Utility.getDateTimeonPeriod(-1),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics"));
		items.add(new BillItem("ctype-cables",329.0,"electronics"));
		items.add(new BillItem("mobilecover",129.0,"electronics"));
		items.add(new BillItem("spices",29.0,"grocery"));
		items.add(new BillItem("chilly",29.0,"grocery"));
		items.add(new BillItem("Rice",129.0,"grocery"));
		
		assertEquals(834.0, storeService.calculateDiscount(items, customer),0.0);
	}


	
	
}
