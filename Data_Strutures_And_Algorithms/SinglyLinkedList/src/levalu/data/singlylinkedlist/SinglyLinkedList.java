package levalu.data.singlylinkedlist;

public class SinglyLinkedList {
	private int length;
	SinglyLinkedListNode head;
	
	public SinglyLinkedList() {
		length = 0;
	}
	
	
	// Get the length of the list
	public int getLength() {
		return length;
	}


	// Return a first node in the list
	public synchronized SinglyLinkedListNode getHead() {
		return head;
	}
	
	// Insert a node at the beginning of the list
	public synchronized void insertAtBegin(SinglyLinkedListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}
	
	// Insert a node at the end of the list
	public synchronized void insertAtEnd(SinglyLinkedListNode node) {
		if(head == null) {
			head = node;
		} else {
			SinglyLinkedListNode p,q;
			for(p = head; (q = p.getNext()) != null; p = q);
			p.setNext(node);
		}
		length++;
	}
	
	// Add a new value to the list at given position
	public synchronized void  insert(int data, int position) {
		// fix the position
		if(position < 0) {
			position = 0;
		}
		
		// fix the position
		if(position > length) {
			position = length;
		}
		
		// if the list is empty, make it only one element
		if(head == null) {
			head = new SinglyLinkedListNode(data);
		}
		// adding at the beginning of the list
		else if (position == 0) {
			SinglyLinkedListNode temp = new SinglyLinkedListNode(data);
			temp.setNext(head);
			head = temp;
		}
		// else find the correct position and insert
		else {
			SinglyLinkedListNode temp = head;
			for(int i = 0; i < position - 1; i++) {
				temp = temp.getNext();
			}
			
			SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
		// Increase the length of the list by 1
		length++;
	}
	
	// Remove and return the node at the head of the list
	public synchronized SinglyLinkedListNode removeFromBegin() {
		SinglyLinkedListNode node = head;
		if(node != null) {
			head = node.getNext();
			node.setNext(null);
			length--;
		}
		
		return node;
	}
	
	// Remove and return the node at the end of the list
	public synchronized SinglyLinkedListNode removeFromEnd() {
		if(head == null) {
			return null;
		}
		
		SinglyLinkedListNode p = head, q = null, next = head.getNext();
		
		if(next == null) {
			head = null;
			length--;
			return p;
		}
		while((next = p.getNext()) != null) {
			q = p;
			p = next;
		}
		q.setNext(null);
		length--;
		return p;
	}
	
	// Remove a node matching a specified node from list
	// Use equals() instead of  == to test matched node.
	
	public synchronized void removeMatched(SinglyLinkedListNode node) {
		if(head == null) {
			return;
		}
		
		if(node.equals(head)) {
			head = head.getNext();
			length--;
			return;
		}
		
		SinglyLinkedListNode p = head, q = null;
		while((q = p.getNext()) != null) {
			if(node.equals(q)) {
				p.setNext(q.getNext());
				length--;
				return;
			}
			
			p = q;
		}
	}
	
	// Remove the value at a given position
	// If the position less than 0, remove the value at position 0.
	// If the position greater than or equal to the length of the list, remove the value at the last position.
	public synchronized void remove(int position) {
		// fix position
		if(position < 0) {
			position = 0;
		}
		
		// fix position
		if(position >= length) {
			position = length - 1;
		}
		
		// if nothing is in the list, do nothing
		if(head == null) {
			return;
		}
		
		// remove the head element
		if(position == 0) {
			head = head.getNext();
		}
		// else move to the correct position and remove
		else {
			SinglyLinkedListNode temp  = head;
			for(int i = 0; i < position - 1; i++) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		
		// Reduce the length of the list by 1
		length--;
	}
	
	// Return a string representation of this collection, the the form ["str1", "str2", ...].
	public String toString() {
		String result = "[";
		if(head == null) {
			return result + "]";
		}
		
		result  = result + head.getData();
		SinglyLinkedListNode temp = head.getNext();
		while(temp != null) {
			result = result + ", " + temp.getData();
			temp = temp.getNext();
		}
		
		return result + "]";
	}
	
	// Return the current length of the list.
	public int length() {
		return length;
	}
	
	// Find the position of the first value that is equal to a given value.
	// The equals method is used to determine equality.
	public int getPosition(int data) {
		// Go looking for the data
		SinglyLinkedListNode temp = head;
		int pos = 0;
		while(temp != null) {
			if(temp.getData() == data) {
				// Return the position if found
				return pos;
			}
			pos++;
			temp = temp.getNext();
		}
		// else return some large value
		return Integer.MIN_VALUE;
	}
	
	// Remove every from the list
	public void clearList() {
		// If the list is empty
		if(head == null) {
			return;
		}
		
		// current node start at head node
		SinglyLinkedListNode current = head;
		// temporary node store the current's next node
		SinglyLinkedListNode temp = null;
		
		
		while(current != null) {
			temp = current.getNext();
			current.setNext(null);
			current = temp;
		}
		head = null;
		length = 0;
	}
	
}
