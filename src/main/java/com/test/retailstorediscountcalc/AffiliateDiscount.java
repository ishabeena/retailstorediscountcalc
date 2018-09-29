package com.test.retailstorediscountcalc;

public class AffiliateDiscount implements IDiscountType{

	@Override
	public double applyDiscount(double billAmount) {
		System.out.println("Applying Affiliate discount..."+(0.1 * billAmount));
		return 0.1 * billAmount;
	}

	@Override
	public boolean isPercentageDiscount() {
		return true;
	}
}
