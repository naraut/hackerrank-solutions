package com.java.sample;

import java.util.HashMap;
import java.util.Map;

/**
 *  This class contains 7 methods;
 *  You need to provide either implementation for those which are not implemented,
 *  or description for those which are implemented.
 */
public class Questions {


	/**
	 * Provide description what this method does;
	 * suggest better implementation
	 */
	
	public int question_1(int a, int b){
		while(a > b){
			a = a - b;
		}
		return a;
	}
	
	public int question_12(int a , int b){
		if(b == 0){
			return a;
		}
		if(a > b){
			int c = a%b;
			if(c == 0){
				return b;
			}else{
				return c;
			}
		}
		return a;
	}


	/**
	 * Returns {@code true} if exactly two of input parameters are {@code true}
	 */
	public boolean question_2(boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, boolean b6){
		int count = 0;
		if(b1) count++;
		if(b2) count++;
		if(b3) count++;
		if(b4) count++;
		if(b5) count++;
		if(b6) count++;
		return (count == 2);
	}

	/**
	 * Returns {@code true} if the input is a square of some prime number.
	 * For example:<br>
	 * {@code question_3(2)} is {@code false}<br>
	 * {@code question_3(4)} is {@code true}<br>
	 * {@code question_3(5)} is {@code false}<br>
	 * {@code question_3(9)} is {@code true}<br>
	 * {@code question_3(10)} is {@code false}<br>
	 * {@code question_3(16)} is {@code false}<br>
	 * {@code question_3(25)} is {@code true}<br>
	 */
	public boolean question_3(int num){
		double sr = Math.sqrt((double)num);
		return isPrime(sr);
		
	}
	
	private boolean isPrime(double sq) {
	    for(double i=2;2*i<sq;i++)  {
	        if(sq%i==0) return false;
	    }
	    return true;
	}

	/**
	 * Returns number of different bytes that have specified number bits set to 1.
	 * For example:<br>
	 * {@code question_4(1)} is {@code 8}. Only following bytes have exactly one bit set to 1:
	 * 00000001, 00000010, 00000100, 00001000, 00010000, 00100000, 01000000, 10000000
	 */
	public int question_4(int bits){
		// generate permutations of (8, bits)
		if(bits == 8){
			return 1;
		}
		return factorial(8)/factorial(8-bits);
	}
	
	public int factorial(int num) {
        if(num == 1){
            return 1;
        }
        return num * (factorial(num-1));
    }

	
	
	
	/**
	 * Returns number of numbers which are greater than 0 and lesser than {@code num} and are divisible either by 3 or by 5.
	 * For example:<br>
	 * {@code question_5(5)} is {@code 1}<br>
	 * {@code question_5(6)} is {@code 2}<br>
	 * {@code question_5(25)} is {@code 11}<br>
	 */
	public int question_5(int num){
		int count = 0;
		for(int i=1;i<num;i++){
			if((i%3==0) || (i%5==0)){
				count++;
			}
		}
		return count;
	}

	/**
	 * Defines following sequence fi(n):<br>
	 * fi(0) = 0;<br>
	 * fi(1) = 0;<br>
	 * fi(2) = 1;<br>
	 * fi(n) = fi(n-1) + fi(n-2) - fi(n-3)
	 * Returns nth number of the sequence.
	 * For example:<br>
	 * {@code question_6(1)} is {@code 0}<br>
	 * {@code question_6(2)} is {@code 1}<br>
	 * {@code question_6(3)} is {@code 1}<br>
	 * {@code question_6(4)} is {@code 2}<br>
	 */
	public int question_6(int n){
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();		
		int i,k,t;
		if(m.containsKey(n-3)){
			i = m.get(n-3);
		}else{
			i = fi(n-3);
			m.put(n-3, i);
		}
		
		if(m.containsKey(n-2)){
			k = m.get(n-2);
		}else{
			k = fi(n-2);
			m.put(n-2, k);
		}
		if(m.containsKey(n-1)){
			t = m.get(n-1);
		}else{
			t = fi(n-1);
			m.put(n-1, t);
		}		
		return i+k-t;
		
	}
	
	private int fi(int n){
		
		if(n==0) return 0;
		if(n==1) return 0;
		if(n==2) return 1;	
		return fi(n-1)+fi(n-2)-fi(n-3);
		
	}

	/**
	 * Takes comma-separated list of email addresses and returns comma-separated list of names with proper capitalisation,
	 * assuming that local-part of the email address consists of dot-separated name parts.
	 * For example:<br>
	 * {@code question_7("han.solo@gmail.com")} is {@code "Han Solo"}<br>
	 * {@code question_7("CHEWBACCA@gmail.com,obi.wan.kenobi@gmail.com,")} is {@code "Chewbacca, Obi Wan Kenobi"}<br>
	 */
	public String question_7(String emails){
		String[] t = emails.split("@");
		String fn = t[0];
		String[] s = fn.split(".");
		if(s.length > 1)
		{
			return caps(s[0])+ " " +caps(s[1]);
		}else
		{
			return caps(s[0]);
		}
	}
	
	private String caps(String s){
		String t = s.toLowerCase();
		return t.substring(0,1).toUpperCase() +t.substring(1); 
	}




	public static void main(String args[]){
		Questions questions = new Questions();

		System.out.println("question_1(8, 3) = " + questions.question_1(8, 3));
		System.out.println("question_1(512, 100) = " + questions.question_1(512, 100));

		System.out.println("question_2(false, false, false, false, false, false) = "
				+ questions.question_2(false, false, false, false, false, false));

		System.out.println("question_2(true, true, false, false, false, false) = "
				+ questions.question_2(true, true, false, false, false, false));

		System.out.println("question_2(false, false, true, false, true, false) = "
				+ questions.question_2(false, false, true, false, true, false));

		System.out.println("question_3(2) = " + questions.question_3(2));
		System.out.println("question_3(4) = " + questions.question_3(4));
		System.out.println("question_3(5) = " + questions.question_3(5));
		System.out.println("question_3(9) = " + questions.question_3(9));
		System.out.println("question_3(10) = " + questions.question_3(10));
		System.out.println("question_3(16) = " + questions.question_3(16));
		System.out.println("question_3(25) = " + questions.question_3(25));

		System.out.println("question_4(0) = " + questions.question_4(0));
		System.out.println("question_4(1) = " + questions.question_4(1));
		System.out.println("question_4(7) = " + questions.question_4(7));

		System.out.println("question_5(25) = " + questions.question_5(25));
		System.out.println("question_5(125) = " + questions.question_5(125));
		System.out.println("question_5(25001) = " + questions.question_5(25001));

		System.out.println("question_6(7) = " + questions.question_6(7));
//		System.out.println("question_6(52) = " + questions.question_6(52));

		System.out.println("question_7(\"hans.solo@gmail.com\") = " + questions.question_7("hans.solo.golo@gmail.com"));
//		System.out.println("question_7(\"CHEWBACCA@gmail.com,obi.wan.kenobi@gmail.com,\") = "
//				+ questions.question_7("CHEWBACCA@gmail.com,obi.wan.kenobi@gmail.com,"));


	}

}
