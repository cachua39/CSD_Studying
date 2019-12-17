package data;

public class IntSLL {
	public IntSLLNode head, tail;	// Head and tail of the link list
	public int size;	// Size of the link list
	
	// Default constructor
	public IntSLL()
	{
		head = tail =  null;
		size = 0;
	}

	public boolean isEmpty()
	{
		return head == null;
	}

	public void clear()
	{
		head = tail = null;
		size = 0;
	}

	public void addFirst(int el)
	{
		IntSLLNode newest = new IntSLLNode(el);
		newest.next = head;
		head = newest;
		size++;
		// Check whether the link list is empty
		if(tail == null)
			tail = head;
	}
	
	// print out all info in the link list
	public void traverse() throws Exception 
	{
		if(isEmpty())
		{
			throw new Exception("Empty list");
		}

		IntSLLNode temp = head;
		while(temp != null)
		{
			System.out.print(temp.info + " ");
			temp = temp.next;
		}
	}
	
	// Add a node to the last position
	public void addLast(int el)
	{
		IntSLLNode newest = new IntSLLNode(el);//a
		newest.info = el;//b
		newest.next = null;//c
		
		// check whether the link list is empty
		if(tail != null)
		{
			tail.next = newest;//d
		}
		size++;
		tail = newest;
		if(head == null)
			head = tail;
	}

	// Get list's node at given position
	public IntSLLNode getNode(int position) throws Exception
	{
		if(position < 0 || position >= size)
		{
			throw new Exception("Index out of bound exception!");
		}
		
		IntSLLNode temp = head;
		for(int i = 0; i < position; ++i)
		{
			temp = temp.next;
		}

		return temp;

	}
	
	// Get node's info at given position
	public int get(int position) throws Exception
	{
		IntSLLNode temp = getNode(position);
		return temp.info;
	}
	
	// Add a node at given position
	public void add(int el, int position) throws Exception
	{
		if(position < 0 || position > size)
		{
			throw new Exception("Index out of bound exception!");
		}
		
		if(position == 0) 
		{
			addFirst(el);	
		} else if(position == size) 
		{
			addLast(el);	
		} else
		{
			IntSLLNode prev = getNode(position - 1);
			IntSLLNode after = prev.next;
			
		    IntSLLNode newest = new IntSLLNode(el);
		    
		    newest.next = after;
		    prev.next = newest;
		    size++;
		}
		
	}
	
	// Remove fist list's node
	public int removeFirst() throws Exception
	{
		if(isEmpty())
			throw new Exception("Empty list!");
		
		int headInfo = head.info;
		IntSLLNode next = head.next;
		
		head.next = null;
		head = next;
		size--;
		
		return headInfo;
	}
	
	// Remove last list's node
	public int removeLast() throws Exception
	{
		if(isEmpty())
			throw new Exception("Empty list!");
		int nodeInfo;
		if(head == tail) {
			nodeInfo = tail.info;
			clear();
			return nodeInfo;
		}
		
		IntSLLNode temp = head;
		for(int i = 0; i < size - 2; ++i)
		{
			temp = temp.next;
		}
		nodeInfo = tail.info;
		temp.next = null;
		tail = temp;
		size--;
		
		return nodeInfo;
	}
	
	
	// Remove list's node at given position
	public int removeAt(int position) throws Exception
	{
		if(position < 0 || position >= size)
		{
			throw new Exception("Index out of bound exception!");
		}
		int nodeInfo;
		if(position == 0) {
			nodeInfo = removeFirst();
		}else if(position == size - 1) {
			nodeInfo = removeLast();
		} else {
			IntSLLNode prev = getNode(position - 1);
			IntSLLNode beRemoved = prev.next;
			IntSLLNode after = beRemoved.next;
			
			nodeInfo = beRemoved.info;
			beRemoved.next = null;
			prev.next = after;
		}
		
		return nodeInfo;
	}
	
	
	// Reverse the link list
	public void reverse() throws Exception // require take in place
	{
		if(isEmpty())
			throw new Exception("Empty List");
		IntSLLNode prev = null;
		IntSLLNode next = null;
		IntSLLNode current = head;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		tail = head;
		head = prev;
	}
	
	// Sort the link list in ascending order
	public void sort() throws Exception
	{
		if(isEmpty())
			throw new Exception("Empty list!");
		
		IntSLLNode tempNode;
		for(int i = 0; i < size - 1; i++)
		{
			tempNode = head;
			for(int j = 0; j < size - i - 1; j++)
			{
				if(tempNode.info > tempNode.next.info)
				{
					int temp = tempNode.info;
					tempNode.info = tempNode.next.info;
					tempNode.next.info = temp;
				}
				tempNode = tempNode.next;
			}
			
		}
	}
}
		
