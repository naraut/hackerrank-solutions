package com.hackerrank.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindDigits {
	
	public static void main(String[] args) {
		List<String> inputs = new ArrayList<>();
		
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            inputs.add(s);
        }
		
        printDigits(inputs);
		
		
	}	
	
	private static void printDigits(List<String> inputs) {
		List<char[]> digitList = inputs.stream().map(String::toCharArray).collect(Collectors.toList());
		digitList.stream().map((cArr)-> {
								int count = 0;
								int A = Integer.parseInt(String.valueOf(cArr));
								for(char c: cArr) {									
									int a = Character.getNumericValue(c);
									if(a != 0) {
										if(A%a == 0) {
											count++;
										}									
									}
								}
								return count;
							}).forEach(System.out::println);
	}	
}
