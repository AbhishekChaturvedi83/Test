/**
 * 
 */
package com.discount.stratagy.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.discount.context.DiscountContext;
import com.discount.stratagy.DiscountStrategy;
import com.discount.stratagy.RegularStrategy;

import junit.framework.TestCase;

class TestRegular extends TestCase {

	DiscountContext context = new DiscountContext();
	double billAmount;
	double[] slab = { 5000, 10000, 10000 };
	double[] discount = { 0, 0.10, 0.20 };
	DiscountStrategy rs;

	@BeforeEach
	protected void setUp() throws Exception {
		rs = new RegularStrategy(slab, discount);
		context.setDiscountStrategy(rs);
	}

	@Test
	void test() {
		billAmount = 5000;
		billAmount = context.getFinalBill(billAmount);
		assertTrue("message like not equal ",Double.parseDouble("5000")-billAmount == 0);	
	}
	@Test
	void test2() {
		billAmount = 10000;
		billAmount = context.getFinalBill(billAmount);
		assertTrue("message like not equal ",Double.parseDouble("9500")-billAmount == 0);	
	}
	
	@Test
	void test3() {
		billAmount = 15000;
		billAmount = context.getFinalBill(billAmount);
		assertTrue("message like not equal ",Double.parseDouble("13500")-billAmount == 0);	
	}
	@Test
	void test4() {
		billAmount = 20000;
		billAmount = context.getFinalBill(billAmount);
		assertTrue("message like not equal ",Double.parseDouble("17500")-billAmount == 0);	
	}
}
