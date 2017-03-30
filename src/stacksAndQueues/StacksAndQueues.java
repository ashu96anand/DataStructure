package stacksAndQueues;

import java.util.Scanner;

public class StacksAndQueues {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of elements of Stack and Queue");
		int n = sc.nextInt();
		System.out.println("enter values to be added to Stack and Queue");
		MyStack stack = new MyStack();
		MyQueue queue = new MyQueue();
		for(int i=0; i<n; i++){
			int num = sc.nextInt();
			stack.stackPush(num);
			queue.queueAdd(num);
		}
		sc.close();
		System.out.println("values of stack are");
		while(!stack.isEmpty()){
			int result = stack.stackPop();
			System.out.println(result);
		}
		System.out.println("values of queue are");
		while(!queue.isEmpty()){
			int result1 = queue.queueRemove();
			System.out.println(result1);
		}
	
	}

	private static class MyQueue{
		Node firstNode, currNode;
		/*
			1  2  3  4
			O/P: 1 -> 2 -> 3 -> 4
		*/


		public void queueAdd(int val) {
			Node newNode = new Node();
			newNode.data = val;
			if(firstNode == null){
				firstNode = newNode;
				currNode = firstNode;
			}
			else{
				currNode.next = newNode;
				currNode = newNode;				//(can use newNode OR currNode.next)
			}

		}

		public int queueRemove() {
			if(isEmpty()){
				return Integer.MIN_VALUE;
			}
			else{
				int temp = firstNode.data;
				firstNode = firstNode.next;
				return temp;
			}
			
		}

		public boolean isEmpty() {
			if(firstNode == null){
				return true;
			}
			return false;
		}

	}

	private static class MyStack {
		Node firstNode;

		/*
            1 2 3 4
            O/P: 1 -> 2 -> 3 -> 4
            O/P: 1 <- 2 <- 3 <- 4
                                F
		 */
		public void stackPush(int val) {
			Node newNode = new Node();
			newNode.data = val;
			if(firstNode == null){
				firstNode = newNode;    
			}
			else{
				newNode.next = firstNode;           
				firstNode = newNode;
			}

		}

		public int stackPop() {
			if(firstNode != null){
				int temp = firstNode.data;
				firstNode = firstNode.next;
				return temp;
			}
			return Integer.MIN_VALUE;
		}

		public boolean isEmpty() {

			if(firstNode == null){
				return true;
			}
			return false;
		}

	}



	private static class Node{
		int data;
		Node next;
	}

}
