package org.store.operations.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.store.operations.model.BillItem;
import org.store.operations.model.Cart;
import org.store.operations.model.Customer;
import org.store.operations.util.ApiConstants;
import org.store.operations.util.Utility;

public class TestEmployeeCustomer extends DiscountTypes {

	
	@Autowired
	private CustomerBillService customerBillService;
	
	
	@Test
	public void testEmployeeCustomerGroceryDiscount() {
		loadDiscountTypes();
		Customer customer = new Customer("TEDYFCUV", ApiConstants.EMPLOYEE, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("spices",29.0,"grocery"));
		items.add(new BillItem("chilly",29.0,"grocery"));
		items.add(new BillItem("Rice",129.0,"grocery"));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(182.0, customerBillService.calculateDiscount(cart),0.0);
	}
	
	
	@Test
	public void testEmployeeCustomerNotGroceryDiscount() {
		loadDiscountTypes();
		Customer customer = new Customer("TEDYFCUV", ApiConstants.EMPLOYEE, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics"));
		items.add(new BillItem("ctype-cables",329.0,"electronics"));
		items.add(new BillItem("mobilecover",129.0,"electronics"));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(480.9, customerBillService.calculateDiscount(cart),0.0);
	}
	
	@Test
	public void testEmployeeCustomerDiscount() {
		loadDiscountTypes();
		Customer customer = new Customer("TEDYFCUV", ApiConstants.EMPLOYEE, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics"));
		items.add(new BillItem("ctype-cables",329.0,"electronics"));
		items.add(new BillItem("mobilecover",129.0,"electronics"));
		items.add(new BillItem("spices",29.0,"grocery"));
		items.add(new BillItem("chilly",29.0,"grocery"));
		items.add(new BillItem("Rice",129.0,"grocery"));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(667.9, customerBillService.calculateDiscount(cart),0.0);
	}


	
	
}
