package com.hackerrank.solutions;

public class Chapter3 {
	
	public static void main(String[] args) {
//		queueTest();
//		stackTest();
		
		System.out.println("-----------------");
		/**
		In-Order:   Traverse left node, current node, then right [usually used for binary search trees]
		Pre-Order:  Traverse current node, then left node, then right node.
		Post-Order: Traverse left node, then right node, then current node.
		Insert Node: On a binary search tree, we insert a value v, by comparing it to the root. 
					 If v > root, we go right, and else we go left. We do this until we hit an empty spot in the tree.
		*/
		TreeNode a = createTree();
		preOrderTraversal(a);
		System.out.println("-----------------");
		bfsTraversal(a);
		
	}
	
	private static TreeNode createTree() {
		TreeNode a = new TreeNode(1, null, null);
		TreeNode b = new TreeNode(2, null, null);
		TreeNode c = new TreeNode(3, null, null);
		a.left = b;
		a.right = c;		
		TreeNode d = new TreeNode(4, null, null);		
		TreeNode e = new TreeNode(5, null, null);
		b.left = d;
		b.right = e;
		TreeNode f = new TreeNode(6, null, null);
		TreeNode g = new TreeNode(7, null, null);
		c.left = f;
		c.right = g;
		
		return a;
	}
	
	private static void queueTest() {
		System.out.println("-----------------");
		Queue q = new Queue();
		q.enqueue(new Node(1, null));
		q.enqueue(new Node(2, null));
		q.enqueue(new Node(3, null));
		q.enqueue(new Node(4, null));
		q.enqueue(new Node(5, null));
		System.out.println(q.dequeue().data);
		System.out.println(q.dequeue().data);
		System.out.println(q.dequeue().data);
		System.out.println(q.dequeue().data);
		System.out.println(q.dequeue().data);
	}
	
	private static void stackTest() {
		System.out.println("-----------------");
		Stack s = new Stack();
		s.push(new Node(1, null));
		s.push(new Node(2, null));
		s.push(new Node(3, null));		
		s.push(new Node(4, null));
		s.push(new Node(5, null));
		s.push(new Node(6, null));
		s.push(new Node(7, null));
		
		System.out.println(s.pop().data);
		System.out.println(s.pop().data);
		System.out.println(s.pop().data);
		System.out.println(s.pop().data);
		System.out.println(s.pop().data);
		System.out.println(s.pop().data);
		System.out.println(s.pop().data);
	}
	
	private static void preOrderTraversal(TreeNode a) {		
		Stack stack = new Stack();
		if(a != null) {			
			traverse(a.right, stack);
			traverse(a.left, stack);
			stack.push(new Node(a.data, null));
		}		
		while(true) {
			Node n = stack.pop();
			if(n == null) break;
			System.out.println(n.data);			
		}		
	}
	
	private static void traverse(TreeNode a, Stack stack){
		if(a != null) {
			TreeNode r = a.right;
			if(r != null) {
				traverse(r, stack);
			}
			
			TreeNode l = a.left;
			if(l != null) {				
				traverse(l, stack);				
			}			
			stack.push(new Node(a.data, null));
		}		
	}
	
	private static void bfsTraversal(TreeNode a) {
		Queue queue = new Queue();
		if(a != null) {
			queue.enqueue(new Node(a.data, null));
			TreeNode l = a.left;
			queue.enqueue(new Node(l.data, null));
			TreeNode r = a.right;
			queue.enqueue(new Node(r.data, null));
			
			traverse(l, queue);
			traverse(r, queue);
		}
		
		while(true) {
			Node n = queue.dequeue();
			if(n == null) break;
			System.out.println(n.data);			
		}
	}
	
	private static void traverse(TreeNode a, Queue queue) {
		if(a != null ) {
			TreeNode l = a.left;
			if(l != null) {
				queue.enqueue(new Node(l.data, null));
			}
			TreeNode r = a.right;
			if(r != null) {
				queue.enqueue(new Node(r.data, null));
			}
			
			traverse(l, queue);
			traverse(r, queue);
		}
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

//LIFO
class Stack {
	Node node;	
	
	public Node pop() {
		if(node != null) {
			Node ret = node;
			node = node.next;
			return ret;
		}
		return null;
	}
	
	public void push(Node n) {
		n.next = node;
		node = n;
	}	
}

//FIFO

class Queue {
	Node first, last;
	
	public Node dequeue() {			
		if(first != null) {
			Node ret = first;
			first = first.next;
			return ret;
		}
		return null;
	}
	
	public void enqueue(Node n){
		if(first == null) {
			first = n;
			last = n;
		}else{
			last.next = n;
			last = n;
		}
	}
}

