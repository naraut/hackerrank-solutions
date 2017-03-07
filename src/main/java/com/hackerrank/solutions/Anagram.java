package com.hackerrank.solutions;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Anagram {

	public static void main(String[] args) {		
		System.out.println(isAnagram2("abcdefgh", "chafdegb"));
		System.out.println(permutations("ABCDEFGH"));
	}
	
	private static boolean isAnagram2(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
	    Map<Integer, Long> map = IntStream.range(0, str1.length()).map(str1::charAt).boxed()
	    									.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    Map<Integer, Long> map2 = IntStream.range(0, str2.length()).map(str2::charAt).boxed()
	    									.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    return map.equals(map2);
	}
	
	
//	private static int getPermutations(String s) {
//		
//		
//	}
//	
//	private String getPermString(String s){
//		
//	}
	
	private static int permutations(String s) {
		return factorial(s.length());
	}
	
	
	private static int factorial(int n) {
		if(n == 1) return 1;
		else return n*factorial(n-1);
	}
	
}	
