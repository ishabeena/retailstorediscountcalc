package com.test.retailstorediscountcalc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RetailStoreDiscountCalcTest {
	public static void main(String[] args) {
		List<Item> bill = prepareBill();
		System.out.println("Net Payable = " + DiscountCalculator.getNetAmountAfterDiscount(bill, getCustomer()));
}

	private static Customer getCustomer() {
		Customer customer = new Customer();
		customer.setId("1234");
		customer.setName("Shabeena");
		customer.setCellNumber("123-456-789");
		customer.setDateOfJoining(new Date("09/26/2016"));
		customer.setEmployee(false);
		customer.setAffiliate(true);
		return customer;
	}

	private static List<Item> prepareBill() {
		List<Item> items = new ArrayList<Item>();
		Item item1 = new Item(ItemCode.EGG);
		item1.setPrice(10);
		item1.setQuantity(20);
		Item item2 = new Item(ItemCode.BOOK);
		item2.setPrice(100);
		item2.setQuantity(5);
		Item item3 = new Item(ItemCode.CREAM);
		item3.setPrice(155);
		item3.setQuantity(1);
		Item item4 = new Item(ItemCode.LAMP);
		item4.setPrice(210);
		item4.setQuantity(1);
		Item item5 = new Item(ItemCode.LIPSTICK);
		item5.setPrice(53);
		item5.setQuantity(2);
		Item item6 = new Item(ItemCode.MILK);
		item6.setPrice(12);
		item6.setQuantity(2);
		Item item7 = new Item(ItemCode.OIL);
		item7.setPrice(34);
		item7.setQuantity(2);
		Item item8 = new Item(ItemCode.PEN);
		item8.setPrice(8);
		item8.setQuantity(2);
		Item item9 = new Item(ItemCode.SOAP);
		item9.setPrice(9);
		item9.setQuantity(4);
		Item item10 = new Item(ItemCode.SPOON);
		item10.setPrice(11);
		item10.setQuantity(4);
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);
		items.add(item7);
		items.add(item8);
		items.add(item9);
		items.add(item10);
		return items;
	}
}
