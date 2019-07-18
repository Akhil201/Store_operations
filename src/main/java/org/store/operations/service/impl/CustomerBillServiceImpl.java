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
import org.store.operations.util.ApiConstants;
import org.store.operations.util.Utility;

@Service
public class CustomerBillServiceImpl implements CustomerBillService {
	Logger logger = LoggerFactory.getLogger(CustomerBillServiceImpl.class);

	@Override
	public DiscountResponse calculateDiscount(Cart cart) {
		
		DiscountStrategy strategy = getCustomerDiscountStrategy(cart.getCustomer());
		Double totalAmount = getAmount(cart.getBillItems());
		Double nonGroceryAmount = getAmount(getNonGroceryItems(cart.getBillItems()));
		Double discount =strategy.getDiscount(nonGroceryAmount, totalAmount);
		DiscountResponse response = new DiscountResponse();
		response.setDiscountAmount(discount);
		response.setNetAmount(totalAmount - discount);
		response.setTotalAmount(totalAmount);
		return response;
	}

	
	private List<BillItem> getNonGroceryItems(List<BillItem> billItems){
		return billItems.stream().filter(x -> !x.getItemType().equalsIgnoreCase("grocery")).collect(Collectors.toList()); 
	}

	private DiscountStrategy getCustomerDiscountStrategy(Customer customer) {
		DiscountStrategy strategy = new GeneralCustomer();
		if (customer.getType().equalsIgnoreCase(ApiConstants.GENERAL)) {
			if (isTwoYearOldUser(customer.getCreatedAt())) {
				strategy = new TwoYearCustomer();
			}
		} else if (customer.getType().equals(ApiConstants.AFFILIATED)) {
			strategy = new AffiliatedCustomer();
		} else if (customer.getType().equals(ApiConstants.EMPLOYEE)) {
			strategy = new EmployeeCustomer();
		}
		return strategy;
	}
	
	private Boolean isTwoYearOldUser(String userCreatedDate) {
		String dateTwoYrsBefore = Utility.getDateTimeonPeriod(-2);
		return Utility.compareDates(userCreatedDate, dateTwoYrsBefore);
	}

	@Override
	public Double getAmount(List<BillItem> billitems) {
		return billitems.stream().map(item -> item.getItemPrice() * item.getQuantity()).reduce(0.0, Double::sum);
	}

}
