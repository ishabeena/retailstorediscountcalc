package com.test.retailstorediscountcalc;

import java.util.Arrays;
import java.util.List;

public interface IDiscountType {
	public static final List<ItemType> INELIGIBLE_ITEMS = Arrays.asList(ItemType.GROCERY);

	public double applyDiscount(double billAmount);

	public boolean isPercentageDiscount();
	
	public default boolean isItemEligible(ItemType item) {
		return !INELIGIBLE_ITEMS.contains(item);
	}
}
