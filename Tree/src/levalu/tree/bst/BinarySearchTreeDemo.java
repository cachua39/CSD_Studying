package levalu.tree.bst;

public class BinarySearchTreeDemo {
	public static void main(String[] args) {
		IntBSTManager manager = new IntBSTManager();
		IntBSTNode root = null;
		root = manager.insert(root, 4);
		root = manager.insert(root, 2);
		root = manager.insert(root, 8);
		root = manager.insert(root, 5);
		root = manager.insert(root, 10);
		root = manager.insert(root, 7);
		root = manager.insert(root, 6);
		
		
		System.out.println("Height: " + manager.getHeightByStack(root));
	}
}
