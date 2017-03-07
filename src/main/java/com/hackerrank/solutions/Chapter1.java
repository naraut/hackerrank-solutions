package com.hackerrank.solutions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chapter1 {
	
	public static void main(String[] args) {
		String str = "aabcdefghijk";
		System.out.println(isUnique(str));
		System.out.println(isAnagram2("abcdefgh", "chafdegb"));
		replace("this is a string");
	}
	
	private static boolean isUnique(String str) {
		char[] chars = str.toCharArray();
		Long len = IntStream.range(0, chars.length).boxed().sorted().distinct().collect(Collectors.counting());
		return (chars.length != len.intValue());
	}
	
	private static boolean isAnagram2(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
	    Map<Integer, Long> map = IntStream.range(0, str1.length()).map(str1::charAt).boxed()
	    									.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    Map<Integer, Long> map2 = IntStream.range(0, str2.length()).map(str2::charAt).boxed()
	    									.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    return map.equals(map2);
	}
	
	private static void replace(String str) {
//		String str1 = str.replaceAll(" ", "%20");
//		System.out.println(str1);
		for(int i=0;i<str.length()-1;i++) {
			String s1 = str.substring(i,i+1);
			if(s1.equals(" ") ) {
				str = str.substring(0,i)+ "%20" + str.substring(i+1, str.length());
			}
		}
		System.out.println(str);
	}
}
