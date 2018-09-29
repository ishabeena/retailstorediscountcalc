package com.test.retailstorediscountcalc;

public class EmployeeDiscount implements IDiscountType {

	@Override
	public double applyDiscount(double billAmount) {
		System.out.println("Applying Employee discount..."+(0.3 * billAmount));
		return 0.3 * billAmount;
	}

	@Override
	public boolean isPercentageDiscount() {
		return true;
	}
}
