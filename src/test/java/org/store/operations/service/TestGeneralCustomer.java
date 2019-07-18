package org.store.operations.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.store.operations.StoreOperationsApplicationTests;
import org.store.operations.model.BillItem;
import org.store.operations.model.Cart;
import org.store.operations.model.Customer;
import org.store.operations.util.ApiConstants;
import org.store.operations.util.Utility;

public class TestGeneralCustomer extends StoreOperationsApplicationTests {

	
	@Autowired
	private CustomerBillService customerBillService;
	
	
	@Test
	public void testGeneralCustomerGroceryDiscount() {
		Customer customer = new Customer("YTHGNBKJIU", ApiConstants.GENERAL, Utility.getDateTimeonPeriod(-1),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("spices",29.0,"grocery", 1));
		items.add(new BillItem("chilly",29.0,"grocery", 1));
		items.add(new BillItem("Rice",129.0,"grocery", 1));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(5.0, customerBillService.calculateDiscount(cart).getDiscountAmount(),0.0);
	}
	
	
	@Test
	public void testGeneralCustomerNotGroceryDiscount() {
		Customer customer = new Customer("YTHGNBKJIU", ApiConstants.GENERAL, Utility.getDateTimeonPeriod(-1),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics", 2));
		items.add(new BillItem("ctype-cables",329.0,"electronics", 2));
		items.add(new BillItem("mobilecover",129.0,"electronics", 2));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(65.0, customerBillService.calculateDiscount(cart).getDiscountAmount(),0.0);
	}
	
	@Test
	public void testGeneralCustomerDiscount() {
		Customer customer = new Customer("YTHGNBKJIU", ApiConstants.GENERAL, Utility.getDateTimeonPeriod(-1),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics", 2));
		items.add(new BillItem("ctype-cables",329.0,"electronics", 2));
		items.add(new BillItem("mobilecover",129.0,"electronics", 2));
		items.add(new BillItem("spices",29.0,"grocery", 1));
		items.add(new BillItem("chilly",29.0,"grocery", 1));
		items.add(new BillItem("Rice",129.0,"grocery", 1));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(75.0, customerBillService.calculateDiscount(cart).getDiscountAmount(),0.0);
	}


	
	
}
