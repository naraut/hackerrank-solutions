package com.hackerrank.solutions;

import java.math.BigInteger;
import java.util.Scanner;

public class LongFactorial {
	
	public static void main(String[] args) {
		try( 
			Scanner in = new Scanner(System.in)
		  ) {
				String n = in.next();
				BigInteger fact = factorial(new BigInteger(n));
				System.out.println(fact.toString());
			}
	}
	
	private static BigInteger factorial(BigInteger n) {
		if(n.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}else{
			return factorial(n.subtract(BigInteger.ONE)).multiply(n);
		}
		
	}
}
