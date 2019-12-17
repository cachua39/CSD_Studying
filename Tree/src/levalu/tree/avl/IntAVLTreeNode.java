package levalu.tree.avl;

public class IntAVLTreeNode {
	private int data;
	private IntAVLTreeNode left;
	private IntAVLTreeNode right;
	
	public IntAVLTreeNode(int data, IntAVLTreeNode left, IntAVLTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public IntAVLTreeNode(int data) {
		this(data, null, null);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public IntAVLTreeNode getLeft() {
		return left;
	}

	public void setLeft(IntAVLTreeNode left) {
		this.left = left;
	}

	public IntAVLTreeNode getRight() {
		return right;
	}

	public void setRight(IntAVLTreeNode right) {
		this.right = right;
	}
}
