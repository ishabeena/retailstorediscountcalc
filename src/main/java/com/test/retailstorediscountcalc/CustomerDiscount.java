package com.test.retailstorediscountcalc;

public class CustomerDiscount implements IDiscountType {

	@Override
	public double applyDiscount(double billAmount) {
		System.out.println("Applying Returning Customer discount..."+(0.05 * billAmount));
		return 0.05 * billAmount;
	}

	@Override
	public boolean isPercentageDiscount() {
		return true;
	}
}
