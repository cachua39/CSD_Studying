package levalu.tree.avl;

public class IntAVLTreeDemo {
	public static void main(String[] args) {
		IntAVLTreeNode root = null;
		IntAVLTreeManager manager = new IntAVLTreeManager();
		root = manager.insert(root, 8);
		root = manager.insert(root, 5);
		root = manager.insert(root, 9);
		root = manager.insert(root, 3);
		root = manager.insert(root, 6);
		root = manager.insert(root, 7);
		
		manager.preOrder(root);
	}
}
