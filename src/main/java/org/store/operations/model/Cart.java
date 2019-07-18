package org.store.operations.model;

import java.util.List;

public class Cart {
	
	private List<BillItem> billItems;
	
	private Customer customer;

	public List<BillItem> getBillItems() {
		return billItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Cart(List<BillItem> billItems, Customer customer) {
		super();
		this.billItems = billItems;
		this.customer = customer;
	}

	public Cart() {
		super();
	}
	
	
	
}
