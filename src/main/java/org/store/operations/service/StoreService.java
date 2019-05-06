package org.store.operations.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.store.operations.model.BillItem;
import org.store.operations.model.DiscountType;
import org.store.operations.model.StoreCustomer;
import org.store.operations.util.Utility;

@Component
public class StoreService {
	Logger logger = LoggerFactory.getLogger(StoreService.class);
	@Autowired
	private DiscountStrategy discountStrategy;

	public Double calculateDiscount(List<BillItem> billitems, StoreCustomer customer) {
		try {
			Double customerDiscount = calculateCustomerDiscount(billitems, customer);
			Double commonDiscount = calculateCommonDiscount(billitems);
			logger.info("Customer Discount: {}", customerDiscount);
			logger.info("Common Discount: {}", commonDiscount);
			return (customerDiscount < commonDiscount) ? customerDiscount : commonDiscount;
		} catch (Exception ex) {
			return 0.0;
		}
	}

	private Double calculateCustomerDiscount(List<BillItem> billitems, StoreCustomer customer) {
		Double totalAmount = billitems.stream().map(BillItem::getItemPrice).reduce(0.0, Double::sum);
		DiscountType discountType =discountStrategy.getDiscountStrategy(customer);
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

	private Double calculateCommonDiscount(List<BillItem> billitems) {
		Double totalAmount = billitems.stream().map(BillItem::getItemPrice).reduce(0.0, Double::sum);
		logger.info("Bill totalAmount: {}", totalAmount);
		Integer discount = (totalAmount.intValue() / 100) * 5;
		return totalAmount - discount;
	}

}
