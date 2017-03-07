package com.hackerrank.solutions;

import java.util.Scanner;

public class StairCase {
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			StringBuffer sb = new StringBuffer();
			n++;
			for(int i=1;i<n;i++) {
				int d = n-i+1;
				for(int j=1;j<d-1;j++){
					sb.append(" ");
				}
				for(int k=0;k<i;k++) {
					sb.append("#");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());			
		}
	}
}
