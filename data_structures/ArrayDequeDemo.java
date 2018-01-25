import java.lang.RuntimeException;

public class ArrayDequeDemo {
	
	public static void main(String[] args) {
		ArrayDeque a = new ArrayDeque(100);
	}
	
}

class ArrayDeque {
	
	int head;
	int tail;
	final int CAPACITY;
	final Object[] Q;
	
	public ArrayDeque(int x) {
		head = 1;
		tail = 2;
		CAPACITY = x+2;//2 additional null array elements at the head and the tail
		Q = new Object[CAPACITY];
	}
	
	int next(int i) {
		if(i == CAPACITY) {
			return 1;
		}
		else {
			return i+1;
		}
	}
	
	int previous(int i) {
		if(i == 1) {
			return CAPACITY;
		}
		else {
			return i-1;
		}
	}
		
	boolean isEmpty() {
		if(next(head) == tail) {
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean isFull() {
		if(head == next(tail)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	void insertFirst(Object x) {
		if(isFull()) {
			throw new RuntimeException("Deque Overflow");
		}
		else {
			Q[head-1] = x;
			head = previous(head);
		}
	}
	
	void insertLast(Object x) {
		if(isFull()) {
			throw new RuntimeException("Deque Overflow");
		}
		else {
			Q[tail-1] = x;
			tail = next(tail);
		}
	}
	
	Object removeFirst() {
		if(isEmpty()) {
			throw new RuntimeException("Deque Underflow");
		}
		head = next(head);
		Object temp = Q[head-1];
		Q[head-1] = null;
		return temp;
	}
	
	Object removeLast() {
		if(isEmpty()) {
			throw new RuntimeException("Deque Underflow");
		}
		tail = previous(tail);
		Object temp = Q[tail-1];
		Q[tail-1] = null;
		return temp;
	}
	
	Object first() {
		return Q[next(head)-1];
	}
	
	Object last() {
		return Q[previous(tail)-1];
	}
	
	int size() {
		int size = 0;
		if(tail > head) {
			size = tail-head-1;
		}
		if(tail < head) {
			size = CAPACITY-head+tail-1;
		}
		return size;
	}
}
