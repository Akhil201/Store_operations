package org.store.operations.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.store.operations.model.BillItem;
import org.store.operations.service.ThresholdOfferService;

@Service
public class ThresholdOfferServiceImpl implements ThresholdOfferService {
	
	Logger logger = LoggerFactory.getLogger(ThresholdOfferServiceImpl.class);
	
	public Double reduceFiveOnHundredOffer(List<BillItem> billitems) {
		Double totalAmount = billitems.stream().map(BillItem::getItemPrice).reduce(0.0, Double::sum);
		logger.info("Bill totalAmount: {}", totalAmount);
		Integer discount = (totalAmount.intValue() / 100) * 5;
		return totalAmount - discount;
	}
	

}
