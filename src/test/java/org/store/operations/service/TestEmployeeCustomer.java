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

public class TestEmployeeCustomer extends StoreOperationsApplicationTests {

	
	@Autowired
	private CustomerBillService customerBillService;
	
	
	@Test
	public void testEmployeeCustomerGroceryDiscount() {
		Customer customer = new Customer("TEDYFCUV", ApiConstants.EMPLOYEE, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("toothpaste",29.0,"grocery", 2));
		items.add(new BillItem("brush",29.0,"grocery", 1));
		items.add(new BillItem("soap",129.0,"grocery", 1));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(10.0, customerBillService.calculateDiscount(cart).getDiscountAmount(),0.0);
	}
	
	
	@Test
	public void testEmployeeCustomerNotGroceryDiscount() {
		Customer customer = new Customer("TEDYFCUV", ApiConstants.EMPLOYEE, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics", 2));
		items.add(new BillItem("ctype-cables",329.0,"electronics", 2));
		items.add(new BillItem("mobilecover",129.0,"electronics", 3));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(525.9, customerBillService.calculateDiscount(cart).getDiscountAmount(),0.0);
	}
	
	@Test
	public void testEmployeeCustomerDiscount() {
		Customer customer = new Customer("TEDYFCUV", ApiConstants.EMPLOYEE, Utility.getDateTimeonPeriod(-3),"Sultan");
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,"electronics", 2));
		items.add(new BillItem("ctype-cables",329.0,"electronics", 2));
		items.add(new BillItem("mobilecover",129.0,"electronics", 3));
		items.add(new BillItem("toothpaste",29.0,"grocery", 2));
		items.add(new BillItem("brush",29.0,"grocery", 2));
		items.add(new BillItem("soap",129.0,"grocery", 2));
		
		Cart cart = new Cart(items, customer);
		
		assertEquals(540.9, customerBillService.calculateDiscount(cart).getDiscountAmount(),0.0);
	}


	
	
}
