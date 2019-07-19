package org.store.operations.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.store.operations.model.BillItem;
import org.store.operations.model.Cart;
import org.store.operations.model.Customer;
import org.store.operations.model.DiscountResponse;
import org.store.operations.service.CustomerBillService;
import org.store.operations.strategy.DiscountStrategy;
import org.store.operations.strategy.impl.AffiliatedCustomer;
import org.store.operations.strategy.impl.EmployeeCustomer;
import org.store.operations.strategy.impl.GeneralCustomer;
import org.store.operations.strategy.impl.TwoYearCustomer;
import org.store.operations.util.CustomerType;
import org.store.operations.util.ItemType;
import org.store.operations.util.Utility;

@Service
public class CustomerBillServiceImpl implements CustomerBillService {
	Logger logger = LoggerFactory.getLogger(CustomerBillServiceImpl.class);

	/***
	 * Getting the discounted amount based on customer type and bill items provided
	 */
	@Override
	public DiscountResponse calculateDiscount(Cart cart) {

		DiscountStrategy strategy = getCustomerDiscountStrategy(cart.getCustomer());
		Double totalAmount = getAmount(cart.getBillItems());
		Double nonGroceryAmount = getAmount(getNonGroceryItems(cart.getBillItems()));
		Double discount = strategy.getDiscount(nonGroceryAmount, totalAmount);
		DiscountResponse response = new DiscountResponse();
		response.setDiscountAmount(discount);
		response.setNetAmount(totalAmount - discount);
		response.setTotalAmount(totalAmount);
		return response;
	}

	private List<BillItem> getNonGroceryItems(List<BillItem> billItems) {
		return billItems.stream().filter(x -> x.getItemType() != ItemType.GROCERY)
				.collect(Collectors.toList());
	}

	/***
	 * Returns DiscountStrategy based on the customer type
	 * 
	 * @param customer
	 * @return
	 */
	private DiscountStrategy getCustomerDiscountStrategy(Customer customer) {
		DiscountStrategy strategy = new GeneralCustomer();
		if (customer.getType() == CustomerType.GENERAL) {
			if (Utility.isDateBeforeTheYears(customer.getCreatedAt(), 2)) {
				strategy = new TwoYearCustomer();
			}
		} else if (customer.getType() == CustomerType.AFFILIATED) {
			strategy = new AffiliatedCustomer();
		} else if (customer.getType() == CustomerType.EMPLOYEE) {
			strategy = new EmployeeCustomer();
		}
		return strategy;
	}

	/***
	 * Returns total amount for the bill items
	 */
	@Override
	public Double getAmount(List<BillItem> billitems) {
		return billitems.stream().map(item -> item.getItemPrice() * item.getQuantity()).reduce(0.0, Double::sum);
	}

}
