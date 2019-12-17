package levalu.tree.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IntBSTManager {
	
	public IntBSTManager() {
		
	}
	
	// Function to print out node's data
	public void visit(IntBSTNode node) {
		if(node != null) {
			System.out.println(node.getData() + " ");
		}
	}
	
	// PreOrder Traversal using recursion
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	public void preOrder(IntBSTNode root) {
		if(root != null) {
			visit(root);
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	
	// PreOrder Traversal using stack
	// Time Complexity: O(n)
	// Time Complexity: O(n)
	public void preOdrderByStack(IntBSTNode root) {
		Stack<IntBSTNode> s = new Stack<>();
		if(root == null) {
			System.out.println("Empty Binary Tree");
			return;
		}
		s.push(root);
		IntBSTNode currentNode = null;
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
	public void inOrder(IntBSTNode root) {
		if(root != null ) {
			inOrder(root.getLeft());
			visit(root);
			inOrder(root.getRight());
		}
	}
	
	// InOrder Traversal using stack
	// Time Complexity: O(n)
	// Time Complexity: O(n)
	public void inOrderByStack(IntBSTNode root) {
		if(root == null) {
			System.out.println("Empty Binary Tree");
			return;
		}
		
		Stack<IntBSTNode> s = new Stack<>();
		IntBSTNode currentNode = root;
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
	public void postOrder(IntBSTNode root) {
		if(root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			visit(root);
		}
	}
	
	// PostOrder Traversal using stack
	// Time Complexity: O(n)
	// Time Complexity: O(n)	
	public void postOrderByStack(IntBSTNode root) {
		if(root == null) {
			System.out.println("Empty Binary Tree.");
			return;
		}
		Stack<IntBSTNode> s = new Stack<>();
		IntBSTNode currentNode, prevNode = null;
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
	
	// Level Order Traversal (Breath-First Traversal)
	// Time Complexity: O(n)
	// Time Complexity: O(n)
	public void levelOrder(IntBSTNode root) {
		if(root == null) {
			System.out.println("Empty Binary Tree.");
			return;
		}
		
		Queue<IntBSTNode> q = new LinkedList<>();
		q.offer(root);
		IntBSTNode currentNode = null;
		while(!q.isEmpty()) {
			currentNode = q.poll();
			if(currentNode != null) {
				visit(currentNode);
				if(currentNode.getLeft() != null) {
					q.offer(currentNode.getLeft());
				}
				if(currentNode.getRight() != null) {
					q.offer(currentNode.getRight());
				}
			}
		}
	}
	
	
	// Search Element in BST using recursion
	// Time Complexity: O(n), worst case: when the given binary search tree is a skew tree
	// Space Complexity: O(n), for recursive stack
	public IntBSTNode search(IntBSTNode root, int data) {
		if(root == null) {
			return null;
		}
		if(data < root.getData()) {
			return search(root.getLeft(), data);
		} else if(data > root.getData()) {
			return search(root.getRight(), data);
		}
		return root;
	}
	
	// Search Element is BST - Non-recursion
	// Time Complexity: O(n), worst case: when the given binary search tree is a skew tree
	// Space Complexity: O(1)
	public IntBSTNode searchNonRecursion(IntBSTNode root, int data) {
		if(root == null) {
			return null;
		}
		while(root != null) {
			if(data == root.getData()) {
				return root;
			}else if(data < root.getData()) {
				root = root.getLeft();
			} else if(data > root.getData()) {
				root = root.getRight();
			}
		}
		return null;
	}
	
	// Search for minimum element in BST - Recursion
	// Time Complexity: O(n), worst case: when the given binary search tree is a skew tree
	// Space Complexity: O(n), for recursive stack
	public IntBSTNode searchMin(IntBSTNode root) {
		if(root == null) {
			return null;
		}
		if(root.getLeft() == null) {
			return root;
		}
		return searchMin(root.getLeft());
	}
	
	// Search for minimum element in BST - Non-recursion
	// Time Complexity: O(n), worst case: when the given binary search tree is a skew tree
	// Space Complexity: O(1)
	public IntBSTNode searchMinNonRecursion(IntBSTNode root) {
		if(root == null) {
			return null;
		}
		while(root.getLeft() != null) {
			root = root.getLeft();
		}
		return root;
	}
	
	// Search for maximum element in BST - Recursion
	// Time Complexity: O(n), in worst case (when BST is a right skew tree).
	// Space Complexity: O(n), for recursive stack.
	public IntBSTNode searchMax(IntBSTNode root) {
		if(root == null) {
			return null;
		}
		if(root.getRight() == null) {
			return root;
		}
		return searchMax(root.getRight());
	}
	
	// Search for maximum element in BST - Non-recursion
	// Time Complexity: O(n), worst case: when the given binary search tree is a skew tree
	// Space Complexity: O(1)
	public IntBSTNode searchMaxNonRecursion(IntBSTNode root) {
		if(root == null) {
			return null;
		}
		while(root.getRight() != null) {
			root = root.getRight();
		}
		return root;
	}
	
	// Insert element to BST - Recursion
	// Time Complexity: O(n)
	// Space Complexity: O(n), for recursive stack.
	public IntBSTNode insert(IntBSTNode root, int data) {
		if(root == null) {
			return new IntBSTNode(data);
		}
		if(root.getData() > data) {
			root.setLeft(insert(root.getLeft(), data));
		} else if (root.getData() < data) {
			root.setRight(insert(root.getRight(), data));
		}
		return root;
	}
	
	// Insert element to BST - Non-recursion
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	public void insertNonRecursion(IntBSTNode root, int data) {
		if(root == null) {
			root = new IntBSTNode(data);
			return;
		} 
		IntBSTNode currentNode = root;
		IntBSTNode parentNode = null;
		while(currentNode != null) {
			parentNode = currentNode;
			if(currentNode.getData() > data) {
				currentNode = currentNode.getLeft();
			} else if(currentNode.getData() < data) {
				currentNode = currentNode.getRight();
			} else if(currentNode.getData() == data) {
				System.out.println("The elements data is exist in the tree.");
				return;
			}
		}
		if(parentNode.getData() > data) {
			parentNode.setLeft(new IntBSTNode(data));
		} else if (parentNode.getData() < data) {
			parentNode.setRight(new IntBSTNode(data));
		}
	}
	
	// Delete element in BST - Non-recursion
	public IntBSTNode deleteByCopyingNonRecursion(IntBSTNode root, int data) {
		// Return null if the tree is empty
		if(root == null) {
			System.out.println("Empty List.");
			return root;
		}
		
		IntBSTNode currentNode = root;
		IntBSTNode prevNode = null;
		// Find the location to delete
		while(currentNode != null && currentNode.getData() != data) {
			prevNode = currentNode;
			if(currentNode.getData() > data) {
				currentNode = currentNode.getLeft();
			} else if(currentNode.getData() < data) {
				currentNode = currentNode.getRight();
			}
		}
		
		// The element to delete is not in the tree
		if(currentNode == null) {
			System.out.println("Element Not found!");
			return root;
		}
		
		IntBSTNode tempNode;
		boolean done =false;
		// Algorithm for delete by copying
		while(!done) {
			// Deleted element has one child,
			if(currentNode.getLeft() == null) {
				currentNode = currentNode.getRight();
				done = true;
			} else if(currentNode.getRight() == null) {
				currentNode = currentNode.getLeft();
				done = true;
			}
			// Deleted element has both two children
			else if(currentNode.getLeft() != null && currentNode.getRight() != null) {
				tempNode = currentNode.getLeft();
				prevNode = currentNode;
				while(tempNode.getRight() != null) {
					prevNode = tempNode;
					tempNode = tempNode.getRight();
				}
				currentNode.setData(tempNode.getData());
				currentNode = tempNode;
			}
		}
		
		// Delete the final element that has one child
		prevNode.setRight(currentNode);
		return root;
	}
	
	// Method to return the height of the tree using recursion
	public int getHeight(IntBSTNode root) {
		if(root == null) {
			return 0;
		}
		// Compute the height of each subtree
		int leftHeight = getHeight(root.getLeft());
		int rightHeight = getHeight(root.getRight());
		int maxHeight = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
		return maxHeight;
	} 
	
	// Method to return the height of the tree using stack
	public int getHeightByStack(IntBSTNode root) {
		if(root == null ) {
			return 0;
		}
		Stack<IntBSTNode> s = new Stack<>();
		s.push(root);
		int maxHeight = 0;
		IntBSTNode prevNode = null;
		IntBSTNode currentNode = null;
		while(!s.isEmpty()) {
			currentNode = s.peek();
			if(prevNode == null || prevNode.getLeft() == currentNode || prevNode.getRight() == currentNode) {
				if(currentNode.getLeft() != null) {
					s.push(currentNode.getLeft());
				} else if(currentNode.getRight() != null) {
					s.push(currentNode.getRight());
				}
			} else if(currentNode.getLeft() == prevNode) {
				if(currentNode.getRight() != null) {
					s.push(currentNode.getRight());
				}
			} else {
				s.pop();
			}
			
			prevNode = currentNode;
			if(maxHeight < s.size()) {
				maxHeight = s.size();
			}
		}
		return maxHeight;
	}
}
