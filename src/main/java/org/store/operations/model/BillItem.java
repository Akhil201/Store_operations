package org.store.operations.model;

public class BillItem {

	private String itemName;
	
	private Double itemPrice;
	
	private String itemType;

	public String getItemName() {
		return itemName;
	}


	public Double getItemPrice() {
		return itemPrice;
	}


	public String getItemType() {
		return itemType;
	}


	public BillItem(String itemName, Double itemPrice, String itemType) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemType = itemType;
	}
	
	
	
	
}
