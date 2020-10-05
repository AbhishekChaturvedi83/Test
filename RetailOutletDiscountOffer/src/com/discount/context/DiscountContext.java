package com.discount.context;

import com.discount.stratagy.DiscountStrategy;

public class DiscountContext {
		  private DiscountStrategy strategy;
		  
		  public void setDiscountStrategy(DiscountStrategy strategy) {
		    this.strategy = strategy;
		  }
		public DiscountStrategy getDiscountStrategy() {
		    return strategy;
		  }
		public double getFinalBill(double amount) {
		    return strategy.discount(amount);
		  }

}
