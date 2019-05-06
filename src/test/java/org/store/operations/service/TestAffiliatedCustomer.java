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

public class TestAffiliatedCustomer extends DiscountTypes {

	
	@Autowired
	private StoreService storeService;
	
	
	@Test
	public void testAfflicatedCustomerGroceryDiscount() {
		loadDiscountTypes();
		StoreCustomer customer = new StoreCustomer("FCHGFSAYU", ApiConstants.AFFILIATED, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("spices",29.0,"grocery"));
		items.add(new BillItem("chilly",29.0,"grocery"));
		items.add(new BillItem("Rice",129.0,"grocery"));
		
		assertEquals(182.0, storeService.calculateDiscount(items, customer),0.0);
	}
	
	
	@Test
	public void testAfflicatedCustomerNotGroceryDiscount() {
		loadDiscountTypes();
		StoreCustomer customer = new StoreCustomer("FCHGFSAYU", ApiConstants.AFFILIATED, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics"));
		items.add(new BillItem("ctype-cables",329.0,"electronics"));
		items.add(new BillItem("mobilecover",129.0,"electronics"));
		
		assertEquals(618.3, storeService.calculateDiscount(items, customer),0.0);
	}
	
	@Test
	public void testAfflicatedCustomerDiscount() {
		loadDiscountTypes();
		StoreCustomer customer = new StoreCustomer("FCHGFSAYU", ApiConstants.AFFILIATED, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics"));
		items.add(new BillItem("ctype-cables",329.0,"electronics"));
		items.add(new BillItem("mobilecover",129.0,"electronics"));
		items.add(new BillItem("spices",29.0,"grocery"));
		items.add(new BillItem("chilly",29.0,"grocery"));
		items.add(new BillItem("Rice",129.0,"grocery"));
		
		assertEquals(805.3, storeService.calculateDiscount(items, customer),0.0);
	}


	
	
}
