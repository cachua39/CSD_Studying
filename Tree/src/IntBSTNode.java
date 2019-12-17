import java.util.*;

class TestTree {
	public static void main(String[] args) {
		IntBST tree = new IntBST();
		tree.Insert(50);
		tree.Insert(30);
		tree.Insert(70);
		tree.Insert(20);
		tree.Insert(80);
		tree.Insert(60);
		tree.Insert(40);
		tree.Insert(35);
		tree.Insert(45);
		tree.recursionInsert(31);

		tree.Preorder(tree.root);

		System.out.println(tree.GetLevel(31));

//		System.out.println(tree.height());
//		System.out.println(tree.CountNode(tree.root));
	}
}

public class IntBSTNode {
	public int key;
	IntBSTNode left, right;

	public IntBSTNode(int k) {
		this(k, null, null);
	}

	public IntBSTNode(int k, IntBSTNode l, IntBSTNode r) {
		key = k;
		left = l;
		right = r;
	}
}

class IntBST {
	IntBSTNode root;

	public IntBST() {
		root = null;
	}

	public void visit(IntBSTNode p) {
		if (p != null) {
			System.out.print(p.key + " ");
		}
	}

	public void BreathFirst() {
		IntBSTNode p = root;
		Queue<IntBSTNode> queue = new LinkedList();
		queue.offer(p); // enqueue
		while (queue.isEmpty() == false) {
			p = queue.poll(); // dequeue
			visit(p);
			if (p.left != null)
				queue.offer(p.left);
			if (p.right != null)
				queue.offer(p.right);
		}
	}

	public void Preorder(IntBSTNode p) {
		if (p != null) {
			visit(p);
			Preorder(p.left);
			Preorder(p.right);
		}
	}

	public void Preorder() {
		Preorder(root);
	}

	public void PreorderByStack(IntBSTNode p) {
		Stack<IntBSTNode> s = new Stack();
		s.push(p);
	}

	public void Inorder(IntBSTNode p) {
		if (p != null) {
			Inorder(p.left);
			visit(p);
			Inorder(p.right);
		}
	}

	public void Inorder() {
		Inorder(root);
	}

	public void Postorder(IntBSTNode p) {
		Postorder(p.left);
		Postorder(p.right);
		visit(p);
	}

	public void Postorder() {
		Postorder(root);
	}

	public IntBSTNode Search(IntBSTNode p, int el) {
		boolean Found = false;
		while (p != null && Found == false) {
			if (el == p.key)
				Found = true;
			else {
				if (el < p.key)
					p = p.left;
				else
					p = p.right;
			}
		}
		return p;
	}

	public IntBSTNode Search(int el) {
		return Search(root, el);
	}

	public void Insert(int el) {
		IntBSTNode p = root;
		IntBSTNode parent = null;
		while (p != null) {
			parent = p;
			if (p.key > el)
				p = p.left;
			else
				p = p.right;
		}
		if (root == null)
			root = new IntBSTNode(el, null, null);
		else {
			if (parent.key > el)
				parent.left = new IntBSTNode(el, null, null);
			else
				parent.right = new IntBSTNode(el, null, null);
		}
	}

	public IntBSTNode recursionSearch(IntBSTNode p, int el) {
		if (p == null)
			return null;
		if (p.key > el)
			return recursionSearch(p.left, el);
		else if (p.key < el)
			return recursionSearch(p.right, el);
		return p;
	}

	public IntBSTNode recursionInsert(IntBSTNode p, int el) {
		if (p == null) {
			p = new IntBSTNode(el, null, null);
		} else {
			if (p.key > el) {
				p.left = recursionInsert(p.left, el);
			} else if (p.key < el) {
				p.right = recursionInsert(p.right, el);
			}
		}
		return p;
	}

	public void recursionInsert(int el) {
		recursionInsert(root, el);
	}

	public int CountNode(IntBSTNode p) {
		if (p == null)
			return 0;

		return CountNode(p.left) + CountNode(p.right) + 1;
	}

	public int CountNode() {
		return CountNode(root);
	}

	public int CountLeafNode(IntBSTNode p) {
		if (p == null)
			return 0;
		if (p.left == null && p.right == null)
			return 1;
		return CountLeafNode(p.left) + CountLeafNode(p.right);
	}

	public int CountLeafNode() {
		return CountLeafNode(root);
	}

	public int CountNonterminalNodes(IntBSTNode p) {
		if (p == null)
			return 0;
		if (p.left == null && p.right == null)
			return 0;
		return CountNonterminalNodes(p.left) + CountNonterminalNodes(p.right) + 1;
	}

	public int CountNonterminalNodes() {
		return CountNonterminalNodes(root);
	}

	public int GetLevel(int el) {
		int count = 1;
		boolean found = false;
		IntBSTNode p = root;
		while (p != null) {
			if (p.key == el) {
				found = true;
				return count;
			}
			if (p.key > el)
				p = p.left;
			else if (p.key < el)
				p = p.right;
			count++;
		}
		if (found)
			return count;
		return -1;
	}

	public void deleteByMerging(int el) {
		IntBSTNode tmp, node, p = root, prev = null;
		while (p != null && p.key != el) { // find the node p
			prev = p; // with element el;
			if (p.key < el)
				p = p.right;
			else
				p = p.left;
		}
		node = p;
		if (p != null && p.key == el) {
			if (node.right == null) // node has no right child: its left
				node = node.left; // child (if any) is attached to its
			// parent;
			else if (node.left == null) // node has no left child: its right
				node = node.right; // child is attached to its parent;
			else { // be ready for merging subtrees;
				tmp = node.left; // 1. move left
				while (tmp.right != null) // 2. and then right as far as
					tmp = tmp.right; // possible;
				tmp.right = // 3. establish the link between
						node.right; // the rightmost node of the left
				// subtree and the right subtree;
				node = node.left; // 4.
			}
			if (p == root)
				root = node;
			else if (prev.left == p)
				prev.left = node;
			else
				prev.right = node; // 5.
		} else if (root != null)
			System.out.println("key " + el + " is not in the tree");
		else
			System.out.println("the tree is empty");
	}

	public void deleteByCopying(int el) {
		IntBSTNode node, p = root, prev = null;
		while (p != null && p.key != el) { // find the node p
			prev = p; // with element el;
			if (p.key < el)
				p = p.right;
			else
				p = p.left;
		}
		node = p;
		if (p != null && p.key == el) {
			if (node.right == null) // node has no right child;
				node = node.left;
			else if (node.left == null) // no left child for node;
				node = node.right;
			else {
				IntBSTNode tmp = node.left; // node has both children;
				IntBSTNode previous = node; // 1.
				while (tmp.right != null) { // 2. find the rightmost
					previous = tmp; // position in the
					tmp = tmp.right; // left subtree of node;
				}
				node.key = tmp.key; // 3. overwrite the reference
				// of the key being deleted;
				if (previous == node) // if node's left child's
					previous.left = tmp.left; // right subtree is null;
				else
					previous.right = tmp.left; // 4.
			}
			if (p == root)
				root = node;
			else if (prev.left == p)
				prev.left = node;
			else
				prev.right = node;
		} else if (root != null)
			System.out.println("key " + el + " is not in the tree");
		else
			System.out.println("the tree is empty");
	}

}
