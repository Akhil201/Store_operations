package org.store.operations.model;

public class BillItem {

	private String itemName;
	
	private Double itemPrice;
	
	private String itemType;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public BillItem(String itemName, Double itemPrice, String itemType) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemType = itemType;
	}
	
	
	
	
}
