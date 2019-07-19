package org.store.operations.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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

public class TestAffiliatedCustomer extends StoreOperationsApplicationTests {

	@Autowired
	private CustomerBillService customerBillService;

	@Test
	public void testAfflicatedCustomerGroceryDiscount() {
		Customer customer = new Customer("FCHGFSAYU", CustomerType.AFFILIATED, new Date());
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("spices", 29.0, ItemType.GROCERY, 1));
		items.add(new BillItem("chilly", 29.0, ItemType.GROCERY, 2));
		items.add(new BillItem("Rice", 129.0, ItemType.GROCERY, 3));
		Cart cart = new Cart(items, customer);
		assertEquals(20.0, customerBillService.calculateDiscount(cart).getDiscountAmount(), 0.0);
	}

	@Test
	public void testAfflicatedCustomerNotGroceryDiscount() {
		Customer customer = new Customer("FCHGFSAYU", CustomerType.AFFILIATED, new Date());
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones", 229.0, ItemType.ELECTRONICS, 2));
		items.add(new BillItem("ctype-cables", 329.0, ItemType.ELECTRONICS, 2));
		items.add(new BillItem("mobilecover", 129.0, ItemType.ELECTRONICS, 2));
		Cart cart = new Cart(items, customer);
		assertEquals(202.4, customerBillService.calculateDiscount(cart).getDiscountAmount(), 0.0);
	}

	@Test
	public void testAfflicatedCustomerDiscount() {
		Customer customer = new Customer("FCHGFSAYU", CustomerType.AFFILIATED, new Date());
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones", 229.0, ItemType.ELECTRONICS, 2));
		items.add(new BillItem("ctype-cables", 329.0, ItemType.ELECTRONICS, 3));
		items.add(new BillItem("mobilecover", 129.0, ItemType.ELECTRONICS, 5));
		items.add(new BillItem("spices", 29.0, ItemType.GROCERY, 1));
		items.add(new BillItem("chilly", 29.0, ItemType.GROCERY, 2));
		items.add(new BillItem("Rice", 129.0, ItemType.GROCERY, 3));
		Cart cart = new Cart(items, customer);
		assertEquals(334.0, customerBillService.calculateDiscount(cart).getDiscountAmount(), 0.0);
	}

}
