package com.discount.stratagy;

public class RegularStrategy implements DiscountStrategy {

	private double[] slab;
	private double[] discount;

	public RegularStrategy(double[] slab, double[] discount) {
		this.slab = slab;
		this.discount = discount;
	}

	@Override
	public double discount(double amount) {
		double discountTotal = 0;
		if (amount <= slab[0])
			discountTotal = amount - (slab[0] * discount[0]);
		else if (amount <= slab[1])
			discountTotal = amount - (((amount - slab[0]) * discount[1]) + (slab[0] * discount[0]));
		else
			discountTotal = amount - (((amount - slab[1]) * discount[2]) + ((slab[1] - slab[0]) * discount[1])
					+ (slab[0] * discount[0]));
		return discountTotal;
	}
}
