package org.store.operations.service;

import org.store.operations.model.Cart;

public interface CustomerBillService {

	public Double calculateDiscount(Cart cart);
}
