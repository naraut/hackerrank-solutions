package com.hackerrank.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximalSubArray {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<Integer[]> testCases = new ArrayList<>();
		for(int i=0;i<T;i++) {
			int len = sc.nextInt();
			Integer[] testCase = new Integer[len];
			for(int j=0;j<len;j++) {
				testCase[j] = sc.nextInt();
			}
			testCases.add(testCase);
		}
		
		for(Integer[] testCase: testCases) {
				System.out.println(getMaxContigousSubArray(testCase) + " " +
									getMaxNonContigousSubArray(testCase));
		}
	}
	
	private static long getMaxContigousSubArray(Integer[] array) {
		if(array.length == 1) {
			return array[0];
		}
		
		Long sum = 0L;
		Long bestSum = array[0] + 0L;
		int leastNegative = array[0];
		for(int i=0;i<array.length;i++) {
			int val = array[i];
			sum = sum + val;
			if(sum < 0) {
				sum = 0L;
			}else{
				if(sum > bestSum) {
					bestSum = sum;
				}
			}
		}
		if(bestSum < 0) return leastNegative;
		return bestSum;
	}
	
	private static long getMaxNonContigousSubArray(Integer[] array) {
		if(array.length == 1) {
			return array[0];
		}
		
		long sum = 0L;
		int leastNegative = array[0];
		for(int i=0;i<array.length;i++) {
			int val = array[i];
			if(val > 0) {
				sum = sum + val;
			}else{
				if(val > leastNegative){
					leastNegative = val;
				}
			}
		}
		if(sum == 0) return leastNegative;
		return sum;
	}
}
