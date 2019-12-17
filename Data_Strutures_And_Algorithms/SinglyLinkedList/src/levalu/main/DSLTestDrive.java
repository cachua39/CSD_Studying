package levalu.main;

import levalu.data.doublylinkedlist.DoublyLinkedList;

public class DSLTestDrive {
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		for(int i = 0; i < 10; i++) {
			dll.addFirst(i);
			
		}
		int a = dll.remove(3);
		System.out.println(dll + "\n, data = " + a);
	}
}
