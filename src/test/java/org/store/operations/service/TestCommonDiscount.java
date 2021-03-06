package org.store.operations.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.store.operations.StoreOperationsApplicationTests;
import org.store.operations.model.BillItem;
import org.store.operations.strategy.impl.TwoYearCustomer;
import org.store.operations.util.ItemType;

public class TestCommonDiscount extends StoreOperationsApplicationTests {

	
	@Autowired
	private CustomerBillService customerBillService;
	
	@Test
	public void testCommonDiscount() {
		
		List<BillItem> items = new ArrayList<>();
		items.add(new BillItem("headphones",229.0,ItemType.ELECTRONICS, 2));
		items.add(new BillItem("ctype-cables",329.0,ItemType.ELECTRONICS, 3));
		items.add(new BillItem("mobilecover",129.0,ItemType.ELECTRONICS, 5));
		items.add(new BillItem("spices",29.0,ItemType.GROCERY, 1));
		items.add(new BillItem("chilly",29.0,ItemType.GROCERY, 2));
		items.add(new BillItem("Rice",129.0,ItemType.GROCERY, 3));
		
		Double totalAmount = customerBillService.getAmount(items);
		Integer discount = new TwoYearCustomer().calculateCommonDiscount(totalAmount);
		assertEquals(125, discount,0.0);
	}
	
	
	
}
