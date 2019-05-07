package org.store.operations.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.store.operations.model.Customer;
import org.store.operations.model.DiscountModel;
import org.store.operations.service.DiscountStrategy;
import org.store.operations.util.ApiConstants;
import org.store.operations.util.Utility;

@Service
public class DiscountStrategyImpl implements DiscountStrategy {

	private List<DiscountModel> discountTypes = new ArrayList<>();

	public void setDiscountStrategy(DiscountModel discountType) {
		discountTypes.add(discountType);
	}

	public DiscountModel getDiscountStrategy(Customer customer) {

		DiscountModel discountType = null;
		if (customer.getType().equalsIgnoreCase(ApiConstants.GENERAL)) {
			if (isTwoYearOldUser(customer.getCreatedAt())) {
				discountType = discountTypes.stream()
						.filter(x -> x.getDiscountType().equalsIgnoreCase(ApiConstants.TWO_YEAR_USER_DISCOUNT))
						.findFirst().orElse(null);
			}
		} else {
			discountType = discountTypes.stream().filter(x -> x.getCustomerType().equalsIgnoreCase(customer.getType()))
					.findFirst().orElse(null);
		}

		return discountType;
	}

	private Boolean isTwoYearOldUser(String userCreatedDate) {
		String dateTwoYrsBefore = Utility.getDateTimeonPeriod(-2);
		return Utility.compareDates(userCreatedDate, dateTwoYrsBefore);
	}

}
