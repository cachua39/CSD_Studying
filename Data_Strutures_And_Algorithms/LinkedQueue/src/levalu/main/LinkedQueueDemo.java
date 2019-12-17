package levalu.main;

import levalu.data.Node;
import levalu.data.LinkedQueue;

public class LinkedQueueDemo {
	public static void main(String[] args) {
		LinkedQueue lq = new LinkedQueue();
		lq.enqueue(1);
		lq.enqueue(2);
		lq.enqueue(3);
		lq.enqueue(4);
		lq.enqueue(5);
		
		try {
			System.out.println("Dequeue the element from queue: " + lq.dequeue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
