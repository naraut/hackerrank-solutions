package com.hackerrank.solutions;

public class LLReverse {
	
	public static void main(String[] args) {
		Node A = new Node(1, new Node(2, new Node(3, new Node(4, null))));
		print(A);		
		Node B = Reverse(A);
		print(B);
		
	}
	
	static void print(Node A) {
		Node n = A;
		while(n!= null) {
			System.out.println(n.data + ", ");
			n = n.next;
		}
	}
	static Node Reverse(Node head) {
		  Node previous = null;	
		  Node next;		  
		  while(head != null) {			 
			 next = head.next;
			 head.next = previous;
			 previous = head;
			 head = next;			 
		  }
		return previous;
	}
}
 
class Node {
   int data;
   Node next;
   
   Node(int d, Node next) {
	   this.data = d;
	   this.next = next;
   }
}


