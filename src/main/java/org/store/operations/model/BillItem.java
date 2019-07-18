package org.store.operations.model;

public class BillItem {

	private String itemName;
	
	private Double itemPrice;
	
	private String itemType;
	
	private Integer quantity;
	
	public Integer getQuantity() {
		return quantity;
	}


	public Double getItemPrice() {
		return itemPrice;
	}


	public String getItemType() {
		return itemType;
	}


	public BillItem(String itemName, Double itemPrice, String itemType, Integer quantity) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemType = itemType;
		this.quantity = quantity;
	}


	public BillItem() {
		super();
	}
	
	
}
