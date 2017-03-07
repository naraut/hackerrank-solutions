package com.hackerrank.solutions;

public class HeadOfLinkedList {
	
	private Node add(Node head, int x) {
		Node newHead = new Node();
		newHead.next = head;
		newHead.data = x;
		return newHead;
	}
	
	
	class Node {
		int data;
		Node next;
	}	
}
