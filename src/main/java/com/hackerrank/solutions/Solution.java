package com.hackerrank.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[T];
		List<List<String>> testCases= new ArrayList<List<String>>();
		
		for(int i=0;i<T;i++) {
			arr[i] = sc.nextInt();
			List<String> test = new ArrayList<String>();
			for(int j=0;j<arr[i];j++) {
				test.add(sc.next());
			}
			testCases.add(test);
		}
		
		for(List<String> test : testCases) {
			System.out.println(isAnagramRing(test));
		}
	}
	
	private static boolean isAnagramRing(List<String> test) {
		String first = test.get(0);	
		for(int i=1;i<test.size();i++) {
			boolean isAna = isAnagram(first, test.get(i));
			if(!isAna) return false;
		}
		return true;
	}
	
	public static boolean isAnagram(String firstWord, String secondWord) {
	     char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
	     char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
	     Arrays.sort(word1);
	     Arrays.sort(word2);
	     return Arrays.equals(word1, word2);
	}
}
