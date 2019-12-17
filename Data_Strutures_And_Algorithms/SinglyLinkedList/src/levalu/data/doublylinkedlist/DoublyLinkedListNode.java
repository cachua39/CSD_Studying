package levalu.data.doublylinkedlist;

public class DoublyLinkedListNode {
	private int data;
	private DoublyLinkedListNode prev;
	private DoublyLinkedListNode next;
	
	// Constructor
	public DoublyLinkedListNode(int data) {
		this(data, null, null);
	}
	
	// Constructor
	public DoublyLinkedListNode(int data, DoublyLinkedListNode prev, DoublyLinkedListNode next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	/* These are getters and setters methods */
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}

	public DoublyLinkedListNode getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedListNode prev) {
		this.prev = prev;
	}

	public DoublyLinkedListNode getNext() {
		return next;
	}

	public void setNext(DoublyLinkedListNode next) {
		this.next = next;
	}
	
	
}
