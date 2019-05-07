package org.store.operations.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.store.operations.model.BillItem;
import org.store.operations.model.Cart;
import org.store.operations.model.Customer;
import org.store.operations.service.CustomerBillService;
import org.store.operations.util.ApiConstants;
import org.store.operations.util.Utility;

public class TestAffiliatedCustomer extends DiscountTypes {

	
	@Autowired
	private CustomerBillService customerBillService;
	
	
	@Test
	public void testAfflicatedCustomerGroceryDiscount() {
		loadDiscountTypes();
		Customer customer = new Customer("FCHGFSAYU", ApiConstants.AFFILIATED, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("spices",29.0,"grocery"));
		items.add(new BillItem("chilly",29.0,"grocery"));
		items.add(new BillItem("Rice",129.0,"grocery"));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(182.0, customerBillService.calculateDiscount(cart),0.0);
	}
	
	
	@Test
	public void testAfflicatedCustomerNotGroceryDiscount() {
		loadDiscountTypes();
		Customer customer = new Customer("FCHGFSAYU", ApiConstants.AFFILIATED, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics"));
		items.add(new BillItem("ctype-cables",329.0,"electronics"));
		items.add(new BillItem("mobilecover",129.0,"electronics"));
		
		Cart cart = new Cart(items, customer);
		assertEquals(618.3, customerBillService.calculateDiscount(cart),0.0);
	}
	
	@Test
	public void testAfflicatedCustomerDiscount() {
		loadDiscountTypes();
		Customer customer = new Customer("FCHGFSAYU", ApiConstants.AFFILIATED, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics"));
		items.add(new BillItem("ctype-cables",329.0,"electronics"));
		items.add(new BillItem("mobilecover",129.0,"electronics"));
		items.add(new BillItem("spices",29.0,"grocery"));
		items.add(new BillItem("chilly",29.0,"grocery"));
		items.add(new BillItem("Rice",129.0,"grocery"));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(805.3, customerBillService.calculateDiscount(cart),0.0);
	}


	
	
}
