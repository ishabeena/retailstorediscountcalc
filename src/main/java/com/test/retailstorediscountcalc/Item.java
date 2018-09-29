package com.test.retailstorediscountcalc;

public class Item {
	private ItemCode itemCode;
	private int quantity = 1;
	private double price;

	public Item()
	{
		
	}
	public Item(ItemCode itemCode) {
		this.itemCode = itemCode;
	}

	public ItemCode getItemCode() {
		return itemCode;
	}

	public void setItemCode(ItemCode itemCode) {
		this.itemCode = itemCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return quantity * price;
	}
}
