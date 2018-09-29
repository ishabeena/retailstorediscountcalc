package com.test.retailstorediscountcalc;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class DiscountCalculator {
	public static double getNetAmountAfterDiscount(List<Item> items, Customer customer) throws IllegalArgumentException
	{
		double groceryBill = 0;
		double nonGroceyBill = 0;
		double totalBillAmount = 0;
		
		if (items == null || customer == null)
		{
			throw new IllegalArgumentException("Data is null...");
		}
		
		IDiscountType customerDiscountStrategy = DiscountStrategyType.lookupDiscountStrategy(customer);
		
		for(Item item: items)
		{
			totalBillAmount = totalBillAmount + item.getTotalPrice();
			if (customerDiscountStrategy.isPercentageDiscount() && customerDiscountStrategy.isItemEligible(item.getItemCode().getType()))
			{
				groceryBill = groceryBill + item.getTotalPrice();
			}
			else
			{
				nonGroceyBill = nonGroceyBill + item.getTotalPrice();
			}
		}
		
		double totalDiscount = customerDiscountStrategy.applyDiscount(groceryBill) + DiscountStrategyType.MISC_DISC.getDiscountStrategy().applyDiscount(nonGroceyBill);
		System.out.println("Total Bill = "+totalBillAmount +" Total Discount = "+totalDiscount);
		double netBill = totalBillAmount - totalDiscount;
		DecimalFormat df = new DecimalFormat("#.##");      
		df.setRoundingMode(RoundingMode.HALF_UP);
		netBill = Double.valueOf(df.format(netBill));
		return netBill;
	}
}
