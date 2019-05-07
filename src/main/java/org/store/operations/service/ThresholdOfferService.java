package org.store.operations.service;

import java.util.List;

import org.store.operations.model.BillItem;

public interface ThresholdOfferService {

	public Double reduceFiveOnHundredOffer(List<BillItem> billitems);
}
