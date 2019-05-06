package org.store.operations.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.store.operations.model.DiscountType;
import org.store.operations.model.StoreCustomer;
import org.store.operations.util.ApiConstants;
import org.store.operations.util.Utility;

@Component
public class DiscountStrategy {

	public List<DiscountType> discountTypes = new ArrayList<>();

	public void setDiscountStrategy(DiscountType discountType) {
		discountTypes.add(discountType);
	}

	public DiscountType getDiscountStrategy(StoreCustomer customer) {

		DiscountType discountType = null;
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
