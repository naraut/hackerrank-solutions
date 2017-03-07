package com.hackerrank.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnagramRing {
	
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
			Boolean b = isAnagramRing(test);
			System.out.println(b.toString().toUpperCase());
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
	
	public static boolean isAnagram(String str1, String str2) {
	     char[] str1WithoutSpaces = str1.replaceAll("[\\s]", "").toCharArray();
	     char[] str2WihtoutSpaces = str2.replaceAll("[\\s]", "").toCharArray();
	     Arrays.sort(str1WithoutSpaces);
	     Arrays.sort(str2WihtoutSpaces);
	     return Arrays.equals(str1WithoutSpaces, str2WihtoutSpaces);
	}
	
}

