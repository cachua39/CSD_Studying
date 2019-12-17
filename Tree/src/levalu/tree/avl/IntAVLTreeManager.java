package levalu.tree.avl;

import java.util.Stack;

public class IntAVLTreeManager {

	// Single rotate the violate node, case 1: Left_Left
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	public IntAVLTreeNode SingleRotateForLeftLeft(IntAVLTreeNode violateNode) {
		IntAVLTreeNode leftNode = violateNode.getLeft();
		violateNode.setLeft(leftNode.getRight());
		leftNode.setRight(violateNode);
		return leftNode;
	}

	// Single rotate the violate node, case 4: Right_Right
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	public IntAVLTreeNode SingleRotateForRightRight(IntAVLTreeNode violateNode) {
		IntAVLTreeNode rightNode = violateNode.getRight();
		violateNode.setRight(rightNode.getLeft());
		rightNode.setLeft(violateNode);

		return rightNode;
	}

	// Double rotate the violate node, for case 2: Left_Right
	public IntAVLTreeNode DoubleRotateLeftRight(IntAVLTreeNode violateNode) {
		violateNode.setLeft(SingleRotateForRightRight(violateNode.getLeft()));
		return SingleRotateForLeftLeft(violateNode);
	}

	// Double Rotate the violate node, for case 3: Right_Left
	public IntAVLTreeNode DoubleRotateRightLeft(IntAVLTreeNode violateNode) {
		violateNode.setRight(SingleRotateForLeftLeft(violateNode.getRight()));
		return SingleRotateForRightRight(violateNode);
	}

	// Method to return the height of the tree using recursion
	public int getHeight(IntAVLTreeNode root) {
		if (root == null) {
			return 0;
		}
		// Compute the height of each subtree
		int leftHeight = getHeight(root.getLeft());
		int rightHeight = getHeight(root.getRight());
		int maxHeight = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
		return maxHeight;
	}

	// Method it insert and check height-balanced
	public IntAVLTreeNode insert(IntAVLTreeNode root, int data) {
		if(root == null) {
			return new IntAVLTreeNode(data);
		}
		
		if(root.getData() > data) {
			root.setLeft(insert(root.getLeft(), data));
			if((getHeight(root.getLeft()) - getHeight(root.getRight())) == 2) {
				if(root.getLeft().getData() > data) {
					root = SingleRotateForLeftLeft(root);
				} else if (root.getLeft().getData() < data) {
					root = DoubleRotateLeftRight(root);
				}
			}
		} else if(root.getData() < data) {
			root.setRight(insert(root.getRight(), data));
			if((getHeight(root.getRight()) - getHeight(root.getLeft()) == 2)) {
				if(root.getRight().getData() < data) {
					root = SingleRotateForRightRight(root);
				} else if(root.getRight().getData() > data) {
					root = DoubleRotateRightLeft(root);
				}
			}
		}
		
		return root;
	}
	
	// Function to print out node's data
		public void visit(IntAVLTreeNode node) {
			if(node != null) {
				System.out.println(node.getData() + " ");
			}
		}
		
		// PreOrder Traversal using recursion
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		public void preOrder(IntAVLTreeNode root) {
			if(root != null) {
				visit(root);
				preOrder(root.getLeft());
				preOrder(root.getRight());
			}
		}
		
		// PreOrder Traversal using stack
		// Time Complexity: O(n)
		// Time Complexity: O(n)
		public void preOdrderByStack(IntAVLTreeNode root) {
			Stack<IntAVLTreeNode> s = new Stack<>();
			if(root == null) {
				System.out.println("Empty Binary Tree");
				return;
			}
			s.push(root);
			IntAVLTreeNode currentNode = null;
			while(!s.isEmpty()) {
				currentNode = s.pop();
				visit(currentNode);
				if(currentNode.getRight()!= null) {
					s.push(currentNode.getRight());
				}
				if(currentNode.getLeft() != null) {
					s.push(currentNode.getLeft());
				}
			}
		}
		
		// InOrder Traversal using recursion
		// Time Complexity: O(n)
		// Time Complexity: O(n)
		public void inOrder(IntAVLTreeNode root) {
			if(root != null ) {
				inOrder(root.getLeft());
				visit(root);
				inOrder(root.getRight());
			}
		}
		
		// InOrder Traversal using stack
		// Time Complexity: O(n)
		// Time Complexity: O(n)
		public void inOrderByStack(IntAVLTreeNode root) {
			if(root == null) {
				System.out.println("Empty Binary Tree");
				return;
			}
			
			Stack<IntAVLTreeNode> s = new Stack<>();
			IntAVLTreeNode currentNode = root;
			boolean done = false;
			
			while(!done) {
				if(currentNode != null) {
					s.push(currentNode);
					currentNode = currentNode.getLeft();
				} else {
					if(s.isEmpty()) {
						done = true;
					} else {
						currentNode = s.pop();
						visit(currentNode);
						currentNode = currentNode.getRight();
					}
					
				}
			}
		}
		
		// PostOrder Traversal using recursion
		// Time Complexity: O(n)
		// Time Complexity: O(n)
		public void postOrder(IntAVLTreeNode root) {
			if(root != null) {
				postOrder(root.getLeft());
				postOrder(root.getRight());
				visit(root);
			}
		}
		
		// PostOrder Traversal using stack
		// Time Complexity: O(n)
		// Time Complexity: O(n)	
		public void postOrderByStack(IntAVLTreeNode root) {
			if(root == null) {
				System.out.println("Empty Binary Tree.");
				return;
			}
			Stack<IntAVLTreeNode> s = new Stack<>();
			IntAVLTreeNode currentNode, prevNode = null;
			s.push(root);
			while(!s.isEmpty()) {
				currentNode = s.peek();
				if(prevNode == null || prevNode.getLeft() == currentNode || prevNode.getRight() == currentNode) {
					if(currentNode.getLeft() != null) {
						s.push(currentNode.getLeft());
					} else if(currentNode.getRight() != null){
						s.push(currentNode.getRight());
					}
				} else if(currentNode.getLeft() == prevNode) {
					if(currentNode.getRight() != null) {
						s.push(currentNode.getRight());
					}
				} else {
					visit(s.pop());
				}
				prevNode = currentNode;
			}
		}
}
