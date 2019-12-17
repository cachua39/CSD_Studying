package main;

import java.util.LinkedList;

import data.*;

class IntSLLNodeTestDrive
{
	public static void main(String[] args){
		IntSLL sll = new IntSLL();
		for(int i = 0; i < 10; i++)
			sll.addFirst(i);
		try {
			sll.reverse();
			sll.add(11,2);
			sll.traverse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}


