package com.test.retailstorediscountcalc;

public enum ItemCode {
	SOAP("Soap", ItemType.GROCERY),
	PEN("Pen", ItemType.STATIONERY),
	LIPSTICK("Lip Stick", ItemType.COSMETICS),
	SPOON("Spoons", ItemType.CROCKERY),
	BOOK("Book", ItemType.STATIONERY),
	OIL("Oil", ItemType.GROCERY),
	CREAM("Face Cream", ItemType.COSMETICS),
	EGG("Eggs", ItemType.GROCERY),
	MILK("Milk", ItemType.GROCERY),
	LAMP("Bed Lamp", ItemType.MISCELLENOUS);
	
	private String name;
	private ItemType type;

	private ItemCode(String name, ItemType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public ItemType getType() {
		return type;
	}
}
