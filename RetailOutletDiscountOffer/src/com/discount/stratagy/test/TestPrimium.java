/**
 * 
 */
package com.discount.stratagy.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.discount.context.DiscountContext;
import com.discount.stratagy.DiscountStrategy;
import com.discount.stratagy.PrimiumStrategy;

import junit.framework.TestCase;


class TestPrimium extends TestCase {

	DiscountContext context = new DiscountContext();
	double billAmount;
	double [] slab = {4000,8000,12000,12000};	
	double [] discount = {0.10,0.15,0.20,0.30};
	DiscountStrategy pr = null;

	@BeforeEach
	protected void setUp() throws Exception {
		pr = new PrimiumStrategy(slab, discount);
		context.setDiscountStrategy(pr);
	
	}
	@Test
	void test() {
		billAmount = 20000;
		billAmount = context.getFinalBill(billAmount);
		assertTrue("message like not equal ",Double.parseDouble("15800")-billAmount == 0);	
	}
	@Test
	void test2() {
		billAmount = 8000;
		billAmount = context.getFinalBill(billAmount);
		assertTrue("message like not equal ",Double.parseDouble("7000")-billAmount == 0);	
	}
	
	@Test
	void test3() {
		billAmount = 4000;
		billAmount = context.getFinalBill(billAmount);
		assertTrue("message like not equal ",Double.parseDouble("3600")-billAmount == 0);	
	}
	@Test
	void test4() {
		billAmount = 12000;
		billAmount = context.getFinalBill(billAmount);
		assertTrue("message like not equal ",Double.parseDouble("10200")-billAmount == 0);	
	}
}
