package com.test.retailstorediscountcalc;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class DiscountCalculatorTest {

	@Test(expected = IllegalArgumentException.class)
	  public void testNullItems() {
	    DiscountCalculator.getNetAmountAfterDiscount(null, new Customer());
	  }
	
	@Test(expected = IllegalArgumentException.class)
	  public void testNullCustomer() {
		DiscountCalculator discountCalculator = new DiscountCalculator();
		discountCalculator.getNetAmountAfterDiscount(prepareBill(), null);
	  }
	
	@Test()
	  public void testReturningCustomerDiscount() {
	    double discount = DiscountCalculator.getNetAmountAfterDiscount(prepareBill(), getReturningCustomer());
	    assertEquals(904.25, discount,0.00);
	  }	
	
	@Test()
	  public void testEmployeeCustomerDiscount() {
	    double discount = DiscountCalculator.getNetAmountAfterDiscount(prepareBill(), getEmployeeCustomer());
	    assertEquals(740.5, discount,0.00);
	  }	
	
	@Test()
	  public void testAffiliateCustomerDiscount() {
	    double discount = DiscountCalculator.getNetAmountAfterDiscount(prepareBill(), getAffiliateCustomer());
	    assertEquals(871.5, discount,0.00);
	  }	
	
	@Test()
	  public void testCustomerDiscount() {
	    double discount = DiscountCalculator.getNetAmountAfterDiscount(prepareBill(), getCustomer());
	    assertEquals(902, discount,0.00);
	  }	
	
	@Test()
	public void testPercentageDiscountForCustomer()
	{
		IDiscountType fiveDollarDiscount = DiscountStrategyType.lookupDiscountStrategy(getCustomer());
		assertEquals(false, fiveDollarDiscount.isPercentageDiscount());
	}
	
	@Test()
	public void testGroceryEligibleForCustomer()
	{
		IDiscountType fiveDollarDiscount = DiscountStrategyType.lookupDiscountStrategy(getCustomer());
		assertEquals(true, fiveDollarDiscount.isItemEligible(ItemType.GROCERY));
	}
	
	@Test()
	public void testPercentageDiscountForEmployee()
	{
		IDiscountType employeeDiscount = DiscountStrategyType.lookupDiscountStrategy(getEmployeeCustomer());
		assertEquals(true, employeeDiscount.isPercentageDiscount());
	}
	
	@Test()
	public void testGroceryEligibleForEmployee()
	{
		IDiscountType employeeDiscount = DiscountStrategyType.lookupDiscountStrategy(getEmployeeCustomer());
		assertEquals(false, employeeDiscount.isItemEligible(ItemType.GROCERY));
	}
	
	@Test()
	public void testPercentageDiscountForReturningCustomer()
	{
		IDiscountType customerDiscount = DiscountStrategyType.lookupDiscountStrategy(getReturningCustomer());
		assertEquals(true, customerDiscount.isPercentageDiscount());
	}
	
	@Test()
	public void testGroceryEligibleForReturningCustomer()
	{
		IDiscountType customerDiscount = DiscountStrategyType.lookupDiscountStrategy(getReturningCustomer());
		assertEquals(false, customerDiscount.isItemEligible(ItemType.GROCERY));
	}
	
	@Test()
	public void testPercentageDiscountForAffiliate()
	{
		IDiscountType affiliateDiscount = DiscountStrategyType.lookupDiscountStrategy(getAffiliateCustomer());
		assertEquals(true, affiliateDiscount.isPercentageDiscount());
	}
	
	@Test()
	public void testGroceryEligibleForAffiliate()
	{
		IDiscountType affiliateDiscount = DiscountStrategyType.lookupDiscountStrategy(getAffiliateCustomer());
		assertEquals(false, affiliateDiscount.isItemEligible(ItemType.GROCERY));
	}
	
	@Test
	public void testItem(){
	   Item item = getItem();
	  assertEquals(ItemCode.EGG, item.getItemCode());
	  assertEquals(ItemType.GROCERY, item.getItemCode().getType());
	  assertEquals("Eggs",ItemCode.EGG.getName());
	  assertEquals(10, item.getPrice(),0.00);
	  assertEquals(20, item.getQuantity());
	  assertEquals(200, item.getTotalPrice(),0.00);
	}
	
	@Test
	public void testReturningCustomer(){
	   Customer customer = getReturningCustomer();
	  assertEquals("123-456-789", customer.getCellNumber());
	  assertEquals("1234", customer.getId());
	  assertEquals("Shabeena", customer.getName());
	  assertEquals(false, customer.isAffiliate());
	  assertEquals(false, customer.isEmployee()); 
	  assertEquals(true, customer.isReturningCustomer());
	}
	
	@Test
	public void testCustomerNullDateOfJoining(){
	   Customer customer = getCustomer();
	  assertEquals("123-888-089", customer.getCellNumber());
	  assertEquals("1289", customer.getId());
	  assertEquals("Mary", customer.getName());
	  assertEquals(false, customer.isAffiliate());
	  assertEquals(false, customer.isEmployee()); 
	  assertEquals(false, customer.isReturningCustomer());
	  assertEquals(null, customer.getDateOfJoining()); 
	}
	
	@Test
	public void testEmployee(){
	   Customer customer = getEmployeeCustomer();
	  assertEquals("123-456-1111", customer.getCellNumber());
	  assertEquals("1235", customer.getId());
	  assertEquals("Bobby", customer.getName());
	  assertEquals(false, customer.isAffiliate());
	  assertEquals(true, customer.isEmployee()); 
	  assertEquals(false, customer.isReturningCustomer());
	}
	
	private List<Item> prepareBill() {
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
		Item item4 = new Item(ItemCode.MILK);
		item4.setPrice(12);
		item4.setQuantity(2);
		Item item5 = new Item();
		item5.setItemCode(ItemCode.OIL);
		item5.setPrice(34);
		item5.setQuantity(2);
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		return items;
	}
	
	private Item getItem()
	{
		Item item = new Item(ItemCode.EGG);
		item.setPrice(10);
		item.setQuantity(20);
		return item;
	}
	
	private static Customer getReturningCustomer() {
		Customer customer = new Customer();
		customer.setId("1234");
		customer.setName("Shabeena");
		customer.setCellNumber("123-456-789");
		customer.setDateOfJoining(new Date("09/26/2016"));
		return customer;
	}
	
	private static Customer getEmployeeCustomer() {
		Customer customer = new Customer();
		customer.setId("1235");
		customer.setName("Bobby");
		customer.setCellNumber("123-456-1111");
		customer.setDateOfJoining(new Date("09/26/2017"));
		customer.setEmployee(true);
		return customer;
	}
	
	private static Customer getAffiliateCustomer() {
		Customer customer = new Customer();
		customer.setId("1239");
		customer.setName("John");
		customer.setCellNumber("123-456-1111");
		customer.setDateOfJoining(new Date("09/26/2014"));
		customer.setAffiliate(true);
		return customer;
	}
	
	private static Customer getCustomer() {
		Customer customer = new Customer();
		customer.setId("1289");
		customer.setName("Mary");
		customer.setCellNumber("123-888-089");
		return customer;
	}
}
