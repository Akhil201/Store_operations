package org.store.operations.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.operations.model.BillItem;
import org.store.operations.model.Cart;
import org.store.operations.model.Customer;
import org.store.operations.model.DiscountModel;
import org.store.operations.service.CustomerBillService;
import org.store.operations.service.DiscountStrategy;
import org.store.operations.service.ThresholdOfferService;
import org.store.operations.util.Utility;

@Service
public class CustomerBillServiceImpl implements CustomerBillService{
	Logger logger = LoggerFactory.getLogger(CustomerBillServiceImpl.class);
	
	@Autowired
	private DiscountStrategy discountStrategy;
	
	@Autowired
	ThresholdOfferService thresholdOfferService;
	
	public Double calculateDiscount(Cart cart) {
		
		Double customerDiscount = calculateCustomerDiscount(cart.getBillItems(), cart.getCustomer());
		Double commonDiscount = thresholdOfferService.reduceFiveOnHundredOffer(cart.getBillItems());
		logger.info("Customer Discount: {}", customerDiscount);
		logger.info("Common Discount: {}", commonDiscount);
		return (customerDiscount < commonDiscount) ? customerDiscount : commonDiscount;
	}

	private Double calculateCustomerDiscount(List<BillItem> billitems, Customer customer) {
		Double totalAmount = billitems.stream().map(BillItem::getItemPrice).reduce(0.0, Double::sum);
		DiscountModel discountType = discountStrategy.getDiscountStrategy(customer);
		if (discountType != null) {
			Double customerPercentage = discountType.getPercentage();
			logger.info("Customer Percentage: {}", customerPercentage);
			Double applicableAmount = billitems.stream().filter(x -> !x.getItemType().equalsIgnoreCase("grocery"))
					.map(BillItem::getItemPrice).reduce(0.0, Double::sum);
			logger.info("Discount applicable amount: {}", applicableAmount);
			Double discountedAmount = Utility.getDiscountValue(customerPercentage, applicableAmount);
			logger.info("Customer specific discount applied amount: {}", discountedAmount);
			return totalAmount - discountedAmount;
		} else {
			return totalAmount;
		}

	}

	

}
