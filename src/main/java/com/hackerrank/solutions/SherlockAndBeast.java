package com.hackerrank.solutions;

import java.util.Scanner;

public class SherlockAndBeast {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[T];
		for(int i=0;i<T;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<T;i++) {
			System.out.println(sherlock(arr[i]));
		}
	}
	
	private static String sherlock(final int target) {
	    int threes = 0;
	    int fives = 0;
	    int digits = target;
	    while (digits > 0) {
	        if (digits % 3 == 0) {
	            fives = digits;
	            break;
	        }
	        digits -= 5;
	    }
	    threes = target - digits;
	    if (digits < 0 || threes % 5 != 0) {
	        return "-1";
	    }
	    StringBuilder sb = new StringBuilder(target);
	    while (fives-- > 0) {
	        sb.append("5");
	    }
	    while (threes-- > 0) {
	        sb.append("3");
	    }
	    return sb.toString();
	}
}
