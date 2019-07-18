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
import org.store.operations.service.CustomerBillService;
import org.store.operations.util.ApiConstants;
import org.store.operations.util.Utility;

public class TestAffiliatedCustomer extends StoreOperationsApplicationTests {

	
	@Autowired
	private CustomerBillService customerBillService;
	
	
	@Test
	public void testAfflicatedCustomerGroceryDiscount() {
		Customer customer = new Customer("FCHGFSAYU", ApiConstants.AFFILIATED, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("spices",29.0,"grocery", 1));
		items.add(new BillItem("chilly",29.0,"grocery", 2));
		items.add(new BillItem("Rice",129.0,"grocery", 3));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(20.0, customerBillService.calculateDiscount(cart).getDiscountAmount(),0.0);
	}
	
	
	@Test
	public void testAfflicatedCustomerNotGroceryDiscount() {
		Customer customer = new Customer("FCHGFSAYU", ApiConstants.AFFILIATED, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics", 2));
		items.add(new BillItem("ctype-cables",329.0,"electronics", 2));
		items.add(new BillItem("mobilecover",129.0,"electronics", 2));
		
		Cart cart = new Cart(items, customer);
		assertEquals(202.4, customerBillService.calculateDiscount(cart).getDiscountAmount(),0.0);
	}
	
	@Test
	public void testAfflicatedCustomerDiscount() {
		Customer customer = new Customer("FCHGFSAYU", ApiConstants.AFFILIATED, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics", 2));
		items.add(new BillItem("ctype-cables",329.0,"electronics", 3));
		items.add(new BillItem("mobilecover",129.0,"electronics", 5));
		items.add(new BillItem("spices",29.0,"grocery", 1));
		items.add(new BillItem("chilly",29.0,"grocery", 2));
		items.add(new BillItem("Rice",129.0,"grocery", 3));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(334.0, customerBillService.calculateDiscount(cart).getDiscountAmount(),0.0);
	}


	
	
}
