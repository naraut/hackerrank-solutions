package com.java.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

class Solution {
	public static final Object DUMMY = new Object();
	
    public int solution(int[] A) {
    	int MAX_COUNT = 1000000000;
    	int count = 0;
    	for(int i=0; i<A.length-1;i++) {
    		for(int j=i+1; j<A.length ;j++) {
    			if(A[i] == A[j]) {
    				++count;		
    				if(count > MAX_COUNT){
    					return MAX_COUNT;
    				}
    			}
    		} 
    	}
    	return count;
    }
    
    public int solution1(int[] A) {
    	int count = 0;
    	TreeSet<Node<Integer>> tree = new TreeSet<>();
    	int index = 0;
    	for(int a : A) {
    		tree.add(new Node<Integer>(index, a));
    		index++;
    	}
    	
    	Node<Integer>[] sorted = tree.toArray(new Node[tree.size()]);
    	for(int i=0;i<sorted.length;i++) {
    		     		
    		
    	}
    	return count;
    }
    
    public int solution2(int[] A) {
    	HashSet<Integer> set = new HashSet<>();
    	HashSet<Integer> list = new HashSet<>();
    	for(int a :A) {
    		boolean notExists = set.add(a);
    		if(notExists) {
    			list.add(a);
    		}
    	}
    	return list.size();
    	
    }
    
    public static void main(String[] args) {
		int[] A = {3,5,6,3,3,5};
		Solution s = new Solution();
		System.out.println(s.solution2(A)); 	
	}
    
}

class Node<T> implements Comparable<Node<Integer>> {
	 int index;
	 int value;
	 
	 Node(int i, int t) {
		 this.index = i;
		 this.value = t;
	 }

	@Override
	public int compareTo(Node<Integer> obj) {
		if(obj != null) {
			if(obj instanceof Node) {
				Node<Integer> other = (Node<Integer>)obj;				
				int ret = Integer.compare(this.value, other.value);
				if(ret == 0) {
					return Integer.compare(this.index, other.index); 
				}
				return ret;
			}
		}
		return -1;
	}

	
}