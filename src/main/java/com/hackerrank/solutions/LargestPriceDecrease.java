package com.hackerrank.solutions;

import java.util.Scanner;

public class LargestPriceDecrease {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int n = sc.nextInt();
		double[] prices = new double[n];
		for(int k=0;k<n;k++){
			prices[k] = getPrice(p, a, b, c, d, k);
			System.out.print(prices[k] + " ");
		}
		System.out.println("\n------");
		System.out.println(findLargestPriceDrop(prices));
	}
	
	private static double findLargestPriceDrop(double[] prices) {
		double diff = 0;
		double largestDiff = 0;
		for(int i=0;i<prices.length;i++) {
			double first = prices[i];			
			for(int j=i+1;j<prices.length;j++) {
				double next = prices[j];
				if(next < first) {
					diff = first - next;
					if(diff > largestDiff) {
						largestDiff = diff;				
					}
				}				
			}
		}
		return largestDiff;
	}
	
	private static double getPrice(int p, int a, int b, int c , int d , int k) {
		//price(k) = p · (sin(a · k + b) + cos(c · k + d) + 2)
		return p *( Math.sin(a*k+b) + Math.cos(c*k+d) + 2);		
	}
}
