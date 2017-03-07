package com.hackerrank.solutions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeConversion {
	
	//07:05:45PM
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String s = sc.next();
			DateFormat sdf1 = new SimpleDateFormat("hh:mm:ssa");
			DateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
			Date d1 = sdf1.parse(s);
			System.out.println(sdf2.format(d1));
			
		}catch(ParseException e) {
			e.printStackTrace();
		}		
	}
}
