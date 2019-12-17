package data;


public class IntSLLNode {
	public int info;
	public IntSLLNode next;
	
	// Constructor with one argument: info
	public IntSLLNode(int i)
	{
		info = i;
		next = null;
	}

	// Constructor with two arguments: info and the next node
	public IntSLLNode(int i, IntSLLNode n)
	{
		info = i;
		next = n;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}
	
}
