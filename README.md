# retailstorediscountcalc
-This is a maven project. Import project into Eclipse as Maven project.
-This application takes the bill which contains the list of items and computes the net amount after computing discount based on customer rules.

-To run the application run RetailStoreDiscountCalcTest.java

-To run junit test case, run DiscountCalculatorTest.java

-To generate junit coverage, right click on DiscountCalculatorTest.java and select Coverage as and select Junit test

-View the coverage report under docs/coverage.jpg

-view the class diagram under docs/classdiagram.jpg


-pom.xml
-Clean install the pom.xml to maven install the project.

src/main/java
-RetailStoreDiscountCalcTest.java, constains the main() method. This is the client code which calls the DiscountCalculator.java's static factory method getNetAmountAfterDiscount().

-DiscountCalculator.java's method getNetAmountAfterDiscount() accepts the final bill(List of items) and customer object. Determine the correct discount strategy class which implements iDiscountType and call the applyDiscount() method to calculate discount. Calculates the net amount and returns.

-DiscountStrategyType->lookupDiscountStrategy() method returns the instance object of IDiscountType based on customer eligibity. This uses Factory Pattern

-iDiscountType interface contains two abstract methods applyDiscount() and isPercentageDiscount() and one default method isItemEligible(). The implementation classes EmployeeDiscount, CustomerDiscount, AffiliateDiscount, FiveDollarDiscount implement the methods of IDiscountType. This uses Strategy Design Pattern.

