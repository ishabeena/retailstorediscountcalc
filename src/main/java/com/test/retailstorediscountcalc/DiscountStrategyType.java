package com.test.retailstorediscountcalc;

public enum DiscountStrategyType {
	EMP_DISC(CustomerType.EMPLOYEE, new EmployeeDiscount()),
	AFF_DISC(CustomerType.AFFILIATE, new AffiliateDiscount()),
	CUST_DISC(CustomerType.RETURNING_CUSTOMER, new CustomerDiscount()),
	MISC_DISC(CustomerType.CUSTOMER, new FiveDollarDiscount());
	
	private CustomerType customerType;
	private IDiscountType discountStrategy;

	private DiscountStrategyType(CustomerType customerType, IDiscountType discountStrategy) {
		this.customerType = customerType;
		this.discountStrategy = discountStrategy;
	}
	
	public CustomerType getCustomerType() {
		return customerType;
	}

	public IDiscountType getDiscountStrategy() {
		return discountStrategy;
	}

	public static IDiscountType lookupDiscountStrategy(Customer customer) {
		if (customer.isEmployee()) {
			return DiscountStrategyType.EMP_DISC.getDiscountStrategy();
		} else if (customer.isAffiliate()) {
			return DiscountStrategyType.AFF_DISC.getDiscountStrategy();
		} else if (customer.isReturningCustomer()) {
			return DiscountStrategyType.CUST_DISC.getDiscountStrategy();
		}
		return DiscountStrategyType.MISC_DISC.getDiscountStrategy();
	}
}
