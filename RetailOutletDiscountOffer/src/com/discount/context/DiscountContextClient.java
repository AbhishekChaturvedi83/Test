package com.discount.context;

import com.discount.stratagy.DiscountStrategy;
import com.discount.stratagy.PrimiumStrategy;
import com.discount.stratagy.RegularStrategy;

public class DiscountContextClient {
	
	public static void main(String[] args) {  
		DiscountContext context = new DiscountContext();
		double billAmount = 20000;
		
		double[] slab = { 5000, 10000, 10000 };
		double[] discount = { 0, 0.10, 0.20 };
		DiscountStrategy rs = new RegularStrategy(slab, discount);
		context.setDiscountStrategy(rs); 
		System.out.println ("Total Bill after regular discount " + billAmount);
		
		double [] slab1 = {4000,8000,12000,12000};	
		double [] discount1 = {0.10,0.15,0.20,0.30};
		DiscountStrategy pr= new PrimiumStrategy(slab1, discount1);
		
		
		billAmount = context.getFinalBill(billAmount); 
		context.setDiscountStrategy(pr);   
		billAmount = context.getFinalBill(billAmount);
		
		System.out.println ("Total Bill after premium discount " + billAmount);
		 }
}
