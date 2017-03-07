package com.test.java.eigth;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Sample {
	
	public static void main(String[] args) {
		File[] list = new File("c:\\").listFiles(f -> f.isHidden());
//		Arrays.stream(list).forEach(f -> System.out.println(f));
		
		File[] listS = new File("c:\\").listFiles(f -> f.getName().endsWith("s"));
//		Arrays.stream(listS).forEach(f -> System.out.println(f));
		
		Arrays.stream(listFiles("c:\\", (f) -> "dell.sdr".equals(f.getName())))
					.forEach(f -> System.out.println(f));
	}
	
	
	private static File[] listFiles(String loc, FileFilter f) {
		return new File(loc).listFiles(f);
	}
}
