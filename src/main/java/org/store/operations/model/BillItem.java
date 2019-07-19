package org.store.operations.model;

import java.io.Serializable;

import org.store.operations.util.ItemType;

public class BillItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 963258L;

	private String itemName;

	private Double itemPrice;

	private ItemType itemType;

	private Integer quantity;

	public Integer getQuantity() {
		return quantity;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public BillItem(String itemName, Double itemPrice, ItemType itemType, Integer quantity) {
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
