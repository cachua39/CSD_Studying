/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luonglv;

/**
 *
 * @author levalu
 */
public class LinkedList {
    
    static LLNode head;
    
    class LLNode{
        int data;
        LLNode prev, next;

        public LLNode(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }
    
    class TNode {
        int data;
        TNode right, left;

        public TNode(int data) {
            this.data = data;
            right = null;
            left = null;
        }
        
    }
    
    TNode sortedListToBST() {
        int n = countNode(head);
        
        return sortedListToBSTRecu(n);
    }
    
    TNode sortedListToBSTRecu(int n) {
        if(n <= 0) {
            return null;
        }
        
        TNode left = sortedListToBSTRecu(n/2);
        TNode root = new TNode(head.data);
        root.left = left;
        head = head.next;
        root.right = sortedListToBSTRecu(n - n/2 - 1);
        
        return root;
    }
    
    int countNode(LLNode head) {
        int count = 0;
        LLNode temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    
    void add(int data) {
        LLNode newNode = new LLNode(data);
        
        newNode.prev = null;
        newNode.next = head;
        if(head != null) {
            head.prev = newNode;
        }
        
        head = newNode;
    }
    
    void printList(LLNode node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    void preOrder(TNode node){
        if(node == null) {
            return;
        }
        
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public static void main(String[] args) {
        LinkedList llist = new LinkedList(); 
  
        /* Let us create a sorted linked list to test the functions 
           Created linked list will be 7->6->5->4->3->2->1 */
        llist.add(7); 
        llist.add(6); 
        llist.add(5); 
        llist.add(4); 
        llist.add(3); 
        llist.add(2); 
        llist.add(1); 
  
        System.out.println("Given Linked List "); 
        llist.printList(head); 
  
        /* Convert List to BST */
        TNode root = llist.sortedListToBST(); 
        System.out.println(""); 
        System.out.println("Pre-Order Traversal of constructed BST "); 
        llist.preOrder(root); 
    }
}
