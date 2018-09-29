package com.test.retailstorediscountcalc;

public class FiveDollarDiscount implements IDiscountType {
	@Override
	public double applyDiscount(double billAmount) {
		System.out.println("Applying default discount..."+0.05 * (billAmount - (billAmount % 100)));
		return 0.05 * (billAmount - (billAmount % 100));
	}

	@Override
	public boolean isItemEligible(ItemType item) {
		return true;
	}

	@Override
	public boolean isPercentageDiscount() {
		return false;
	}
}
