package com.hackerrank.solutions;

public class HeapSort {

		public static void main(String[] args) {
			int[] A = { 27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0 };
//			int[] A = { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };
			for(int i=0;i<A.length;i++) {
				maxHeapify(A, i);
			}
			
			for(int a:A) {
				System.out.print(a+ ", ");
			}
		}
		
		private static void maxHeapify(int[] A, int i) {			
			if(i > A.length) {
				return;
			}
			
			int leftIndex = 2*i+1;
			int rightIndex = 2*i+2;
			if(A.length > leftIndex) {				
				if(A[i] < A[leftIndex]){
					swap(A, i, (leftIndex));					
				}				
			}			
			if(A.length > rightIndex) {
				if(A[i] < A[rightIndex]) {
					swap(A, i, (rightIndex));
				}
				
			}
			if(A.length>leftIndex) {				
				maxHeapify(A, leftIndex);
			}
			if(A.length>rightIndex) {
				maxHeapify(A, rightIndex);
			}
		}
		
		private static void swap(int[] A, int pos1, int pos2) {			
			int temp = A[pos2];
			A[pos2] = A[pos1];
			A[pos1] = temp;
		}
}
