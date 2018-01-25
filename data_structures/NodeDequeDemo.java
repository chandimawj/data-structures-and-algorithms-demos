//IT3007 Take-home Assignment 2
//Name: W. J. Chandima
//Index No: s12009

import java.lang.RuntimeException;

public class NodeDequeDemo {
	
	public static void main(String[] args) {
		NodeDeque a = new NodeDeque();
	}
	
}

class Node {
	Object value;
	Node previous;
	Node next;
}

class NodeDeque {
	
	final Node head;
	final Node tail;
	int size;

	public NodeDeque() {
		head = new Node();
		tail = new Node();
		size = 0;
		
		head.next = tail;
		head.previous = null;
		
		tail.previous = head;
		tail.next = null;
	}
	
	boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	int size() {
		return size;
	}
	
	void insertFirst(Object x) {
		Node node = new Node();
		node.value = x;
		node.previous = head;
		node.next = head.next;
		head.next.previous = node;
		head.next = node;
		size += 1; 
	}
	
	void insertLast(Object x) {
		Node node = new Node();
		node.value = x;
		node.previous = tail.previous;
		node.next = tail;
		tail.previous.next = node;
		tail.previous = node;
		size += 1;
	}
	
	Object removeFirst() {
		if(isEmpty()) {
			throw new RuntimeException("Deque Underflow");
		}
		Object temp = head.next.value;
		head.next = head.next.next;
		head.next.previous = head;
		size -= 1;
		return temp;
	}
	
	Object removeLast() {
		if(isEmpty()) {
			throw new RuntimeException("Deque Underflow");
		}
		Object temp = tail.previous.value;
		tail.previous = tail.previous.previous;
		tail.previous.next = tail;
		size -= 1;
		return temp;
	}
	
	Object first() {
		return head.next.value;
	}
	
	Object last() {
		return tail.previous.value;
	}

}


