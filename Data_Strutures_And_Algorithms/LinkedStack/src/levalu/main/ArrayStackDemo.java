package levalu.main;

import levalu.data.ArrayStack;

public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack as = new ArrayStack();
		
		as.push(1);
		as.push(2);
		as.push(3);
		as.push(4);
		
		System.out.println("Pop element from top of the stack: " + as.pop());
		System.out.println("Print out the top element from the stack: " + as.top());
	}
}
