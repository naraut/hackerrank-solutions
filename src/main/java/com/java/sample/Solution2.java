package com.java.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Solution2 {
	
	public int solution(String S) throws Exception {
		int totalCost = 0;
		
		Map<Integer, Integer> phoneCount = new HashMap<>();
		List<Integer[]> list = new ArrayList<>();
		int maxCount=0;
		int maxCountPhoneNumber = 0;
		
		StringTokenizer st = new StringTokenizer(S, "\n");	
		while(st.hasMoreTokens()) {
			String s1 = st.nextToken();
			StringTokenizer st2 = new StringTokenizer(s1, ",");
			while(st2.hasMoreTokens()) {
				String duration = st2.nextToken();
				String num = st2.nextToken();
				String[] split = duration.split(":");
				Integer number = Integer.parseInt(num.replaceAll("\\D", ""));
				
				int hour = Integer.parseInt(split[0]);
				int min = Integer.parseInt(split[1]);
				int sec = Integer.parseInt(split[2]);
				
				if(!phoneCount.containsKey(number)){
					phoneCount.put(number, 1);
				}else{
					int i = phoneCount.get(number);
					phoneCount.put(number, ++i);
				}
				Integer[] arr = {number, getCost(hour, min, sec)};
				list.add(arr);
				
				for(Entry<Integer, Integer> entry: phoneCount.entrySet()) {
					if(entry.getValue() >= 1) {
						if(entry.getValue() > maxCount) {
							maxCount = entry.getValue();
							maxCountPhoneNumber = entry.getKey();
						}
					}
				}
			}			
		}
		
		for(Integer[] arrCost : list) {
			if(!(arrCost[0] == maxCountPhoneNumber)) {
				totalCost = totalCost+arrCost[1];
			}
		}
		
		return totalCost;
    }
	
	private int getCost(int h, int m, int s) {
		int cost = 0;
		if(h == 0 && m < 5) {
			return (m*60 + s)*3;
		}
		
		if(h > 0 || m >= 5) {
			if(s == 0) {
				return (m*150);
			}else{
				return ((m+1)*150);
			}
		}		
		return cost;
	}
	
	public static void main(String[] args) throws Exception {
		
		String str = "00:01:07,400-234-090\n00:05:07,400-234-091\n00:01:07,400-234-090";
		Solution2 sol = new Solution2();
		System.out.println(sol.solution(str));
	}
}
