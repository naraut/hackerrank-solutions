package com.hackerrank.solutions;

import java.util.Scanner;

public class GridSearch {
	
	public static void main(String[] args) {
		
		String[] outer;
		String[] inner;
		
		Scanner sc = new Scanner(System.in);
		long T = sc.nextLong();
		for(int i=0;i<T;i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			outer = new String[R];
			for(int h=0;h<R;h++) {
				outer[h]= sc.next();
			}
			
			int r = sc.nextInt();
			int c = sc.nextInt();
			inner = new String[r];
			for(int h=0;h<r;h++) {
				inner[h]= sc.next();
			}
			System.out.println(checkExists(outer, inner));
		}
	}
	
	private static String checkExists(String[] outer, String[] inner) {
		int foundRow = -1, foundIndex= -1;
		
		for(int o=0;o<outer.length;o++){
			foundIndex = outer[o].indexOf(inner[0]);
			if(foundIndex > -1) {
				foundRow = o;	
				break;
			}
		}
		
		if(foundIndex == -1 || (foundRow + inner.length) > (outer.length)){
			return "NO";
		}
		
		int k = 1;
		for(int o=foundRow+1;o<outer.length && k<inner.length;o++){
			int f = outer[o].indexOf(inner[k]);
			if(f == foundIndex) {
				k++;
			}else{
				return "NO";
			}
		}
		return "YES";
	}
}
