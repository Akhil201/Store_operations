package org.store.operations.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.store.operations.StoreOperationsApplicationTests;
import org.store.operations.model.BillItem;
import org.store.operations.model.Cart;
import org.store.operations.model.Customer;
import org.store.operations.util.CustomerType;
import org.store.operations.util.ItemType;

public class TestTwoYearOldCustomer extends StoreOperationsApplicationTests {

	@Autowired
	private CustomerBillService customerBillService;

	@Test
	public void testTwoYearOldCustomerGroceryDiscount() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -2);
		Date joindate = calendar.getTime();
		Customer customer = new Customer("PLKJMCEWS", CustomerType.GENERAL, joindate);
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("spices", 29.0, ItemType.GROCERY, 1));
		items.add(new BillItem("chilly", 29.0, ItemType.GROCERY, 1));
		items.add(new BillItem("Rice", 129.0, ItemType.GROCERY, 1));
		Cart cart = new Cart(items, customer);
		assertEquals(5.0, customerBillService.calculateDiscount(cart).getDiscountAmount(), 0.0);
	}

	@Test
	public void testTwoYearOldCustomerNotGroceryDiscount() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -2);
		Date joindate = calendar.getTime();
		Customer customer = new Customer("PLKJMCEWS", CustomerType.GENERAL, joindate);
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones", 229.0, ItemType.ELECTRONICS, 2));
		items.add(new BillItem("ctype-cables", 329.0, ItemType.ELECTRONICS, 3));
		items.add(new BillItem("mobilecover", 129.0, ItemType.ELECTRONICS, 4));
		Cart cart = new Cart(items, customer);
		assertEquals(291.1, customerBillService.calculateDiscount(cart).getDiscountAmount(), 0.0);
	}

	@Test
	public void testTwoYearOldCustomerDiscount() {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -2);
		Date joindate = calendar.getTime();
		Customer customer = new Customer("PLKJMCEWS", CustomerType.GENERAL, joindate);
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones", 229.0, ItemType.ELECTRONICS, 2));
		items.add(new BillItem("ctype-cables", 329.0, ItemType.ELECTRONICS, 3));
		items.add(new BillItem("mobilecover", 129.0, ItemType.ELECTRONICS, 4));
		items.add(new BillItem("spices", 29.0, ItemType.GROCERY, 1));
		items.add(new BillItem("chilly", 29.0, ItemType.GROCERY, 1));
		items.add(new BillItem("Rice", 129.0, ItemType.GROCERY, 1));
		Cart cart = new Cart(items, customer);
		assertEquals(301.1, customerBillService.calculateDiscount(cart).getDiscountAmount(), 0.0);
	}

}
