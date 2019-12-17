/**
 * The Double Linked List:
 * - isEmpty()
 * - addFirst()
 * - addLast()
 * - add();			//insert at given position
 * - removeFirst()
 * - removeLast()
 * - remove()
 * - toString()
 * - isInList(el)
 */

package levalu.data.doublylinkedlist;


public class DoublyLinkedList {
	// Properties
	private DoublyLinkedListNode head;
	private DoublyLinkedListNode tail;
	private int size;
	
	// Constructors
	public DoublyLinkedList() {
		head = tail = null;
		size = 0;
	}
	
	// Check for empty list
	public boolean isEmpty() {
		return head == null;
	}
	
	// Insert the new data to the beginning of the list
	public void addFirst(int data) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data, null, head);
		if(isEmpty()) {
			tail = newNode;
		} else {
			head.setPrev(newNode);
			head = newNode;
		}
		head = newNode;
		size++;
	}
	
	// Insert the new data to the end of the list
	public void addLast(int data) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data, tail, null);
		if(isEmpty()) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}
	
	// Get the node based on given position
	public DoublyLinkedListNode getNode(int position) {
		// Fix position
		if(position < 0) {
			position = 0;
		}
		// Fix position
		if(position > size) {
			position = size;
		}
		
		// If the list is empty
		if(isEmpty()) {
			return null;
		}
		
		if(position < (size >> 1)) {
			DoublyLinkedListNode temp = head;
			for(int i = 0; i < position; i++) {
				temp = temp.getNext();
			}
			return temp;
		} else {
			DoublyLinkedListNode temp = tail;
			for(int i = size - 1; i > position; i--) {
				temp = temp.getPrev();
			}
			return temp;
		}
		
	}
	
	// Insert the new data at the given position
	public void add(int data, int position) {
		DoublyLinkedListNode temp = getNode(position);
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data, null, null);
		
		// if the list is empty
		if(temp == null) {
			head = tail = newNode;
		}
		// if the temporary node equals the head
		else if(temp.equals(head)) {
			newNode.setNext(temp);
			temp.setPrev(newNode);
			head = newNode;
		}
		// if the temporary node equals the tail
		else if(temp.equals(tail)) {
			newNode.setPrev(temp);
			temp.setNext(newNode);
			tail = newNode;
		}
		// else add the node to the correct position in the list
		else {
			newNode.setPrev(temp.getPrev());
			newNode.setNext(temp);
			temp.getPrev().setNext(newNode);
			temp.setPrev(newNode);
		}
		// Increase size of the list by 1
		size++;
	}
	
	// Remove the node at the beginning of the list
	public int removeFirst() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		if(head.equals(tail)) {
			DoublyLinkedListNode temp = head;
			head = tail = null;
			size--;
			return temp.getData();
		}
		
		DoublyLinkedListNode temp = head;
		head.getNext().setPrev(null);
		head = head.getNext();
		temp.setNext(null);
		size--;
		
		return temp.getData();
	}
	
	// Remove the node at the end of the list
	public int removeLast() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		if(head.equals(tail)) {
			DoublyLinkedListNode temp = head;
			head = tail = null;
			size--;
			return temp.getData();
		}
		
		DoublyLinkedListNode temp = tail;
		tail.getPrev().setNext(null);
		tail = tail.getPrev();
		temp.setPrev(null);
		size--;
		
		return temp.getData();
	}
	
	// Remove the node at the given position
	public int remove(int position) {
		
		// Get the position of the removing node
		DoublyLinkedListNode deletingNode = getNode(position);
		// If the removing node equals to null, mean the list is empty
		if(deletingNode == null) {
			return Integer.MIN_VALUE;
		}
		
		// If the removing is the head of the list
		if(deletingNode.equals(head)) {	
			return removeFirst();
		}
		// If the removing is the tail of the list
		else if(deletingNode.equals(tail)) {
			return removeLast();
		} 
		// Else remove the correct position in the list
		else {
			deletingNode.getPrev().setNext(deletingNode.getNext());
			deletingNode.getNext().setPrev(deletingNode.getPrev());
			deletingNode.setNext(null);
			deletingNode.setPrev(null);
			size--;
			
		}
		return deletingNode.getData();
	}
	
	// Clear the entire list
	public void clear() {
		if(head == null) {
			return;
		}
		
		DoublyLinkedListNode current = head;
		DoublyLinkedListNode temp = null;
		
		while(current != null) {
			temp = current.getNext();
			current.setNext(null);
			current.setPrev(null);
			current = temp;
		}
		head = tail = null;
		size = 0;
	}
	
	// Return a string representation of this collection, the the form ["str1", "str2", ...].
	@Override
	public String toString() {
		String result = "[";
		if(isEmpty()) {
			return result + "]";
		}			
		
		result  = result + head.getData();
		DoublyLinkedListNode temp = head.getNext();
		while(temp != null) {
			result = result + ", " + temp.getData();
			temp = temp.getNext();
		}
			
		return result + "]";
	}
	
}
