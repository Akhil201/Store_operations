package org.store.operations.service;

import java.util.List;

import org.store.operations.model.BillItem;
import org.store.operations.model.Cart;
import org.store.operations.model.DiscountResponse;

public interface CustomerBillService {

	public DiscountResponse calculateDiscount(Cart cart);

	public Double getAmount(List<BillItem> billitems);
}
