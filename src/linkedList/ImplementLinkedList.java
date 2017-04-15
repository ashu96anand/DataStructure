package linkedList;

import java.util.Scanner; 

public class ImplementLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyLinkList linklist = new MyLinkList();
		System.out.println("Enter the no. of elements of LinkList: ");
		int n = sc.nextInt();
		System.out.println("enter values to be added to LinkList: ");
		for(int i=0; i<n; i++){
			int val = sc.nextInt();
			linklist.addInteger(val);
		}
		System.out.println("LInkedList is : ");
		linklist.printLinkList(linklist.firstNode);
		System.out.println("Enter the location to check : ");
		int location = sc.nextInt();
		int result = linklist.getNodeValue(location);
		System.out.println(result);
		System.out.println("Enter the no.of rotations : ");
		int k = sc.nextInt();
		System.out.println("After Rotation : ");
		linklist.linkListLeftRotation(k);
		linklist.printLinkList(linklist.firstNode);
	}

	private static class MyLinkList{

		Node firstNode, currNode;

		public MyLinkList(){
			firstNode = null;
			currNode = null;
		}

		public void addInteger(Integer val) {
			Node newNode = new Node();
			newNode.data = val;
			if(firstNode == null){
				firstNode = newNode;
				currNode = firstNode;
			} 
			else{
				currNode.next = newNode;
				currNode = newNode;
			}
		}

		public void printLinkList(Node firstNode) {
			currNode = firstNode;
			while (currNode != null) {
				System.out.println(currNode.data);
				currNode = currNode.next;
			}
		}

		//11 22 33 44 55
		// 0  1  2  3  4
		public int getNodeValue(int i) {
			currNode = firstNode;
			for(int j=0; j<i; j++){
				if(currNode == null){
					return Integer.MAX_VALUE;
				}
				currNode = currNode.next;
			}
			return currNode.data;
		}
		
		public void linkListLeftRotation(int k){
			if(k == 0){
				return;
			}
			currNode = firstNode;
			int count = 1;
			while(count < k && currNode != null){
				currNode = currNode.next;
				count++;
			}
			if(currNode == null){
				return;
			}
			Node kthNode = currNode;
			while(currNode.next != null){
				currNode = currNode.next;
			}
			currNode.next = firstNode;
			firstNode = kthNode.next;
			kthNode.next = null;
		}

	}

	private static class Node {
		Integer data;
		Node next;
	}
}

