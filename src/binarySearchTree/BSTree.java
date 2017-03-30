package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTree {

	public static void main(String []args) {
		BSTree obj = new BSTree();
		int[] inpArr = {1,2,3,4,5,6,7,8,9};
		int toFind = 2;
		Node rootNode = obj.createBST(inpArr,0, inpArr.length-1);
		Node resNode = obj.find(toFind, rootNode);
		System.out.println("Search result : ");
		System.out.println(resNode.data);
		System.out.println("Inorder : ");
		obj.inorder(rootNode);
		System.out.println();
		System.out.println("Preorder : ");
		obj.preorder(rootNode);
		System.out.println();
		System.out.println("Postorder : ");
		obj.postorder(rootNode);
		System.out.println();
		System.out.println("BFS : ");
		obj.bfs(rootNode);
		System.out.println();
		int val = 10;
		obj.add(rootNode, val);
		System.out.println("After adding value(inorder) : ");
		obj.inorder(rootNode);
		System.out.println();
		System.out.println("Leaf Nodes : ");
		obj.printLeafNodes(rootNode);
		System.out.println("Diameter via RootNode : " + obj.diameterViaRoot(rootNode));
	}

	public void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public void preorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}

	public void bfs(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node currentNode = q.remove();
			System.out.print(currentNode.data + " ");
			if (currentNode.left != null) {
				q.add(currentNode.left);
			}
			if (currentNode.right != null) {
				q.add(currentNode.right);
			}
		}
	} 

	public void printLeafNodes(Node root) {
		if(root == null){
			return;
		}
		printLeafNodes(root.left);
		printLeafNodes(root.right);
		if(root.left == null && root.right == null){
			System.out.println(root.data);
		}
	}

	public int diameterViaRoot(Node root) {
		if (root == null) {
			return 0;
		}    
		return 1 + height(root.left) + height(root.right);
	}
	public int height(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	
	public Node createBST(int[] inp, int startIdx, int endIdx) {
		if (endIdx < startIdx) {
			return null;
		}
		int midIdx = (startIdx + endIdx)/2;
		Node newNode = new Node();
		newNode.data = inp[midIdx];
		newNode.left = createBST(inp, startIdx, midIdx-1);
		newNode.right = createBST(inp, midIdx+1, endIdx);
		return newNode;
	}

	public Node find(int val, Node rootNode) {
		if(rootNode == null){
			return null;
		}
		if(rootNode.data == val){
			return rootNode;
		}
		else{
			if(rootNode.data < val){
				return find(val, rootNode.right);
			}
			else{
				return find(val, rootNode.left);
			}
		}
	}

	public void add(Node rootNode, int val) {
		if(rootNode == null || rootNode.data == val){
			return;
		}
		else{
			if(rootNode.data < val){
				if(rootNode.right == null){
					rootNode.right = new Node();
					rootNode.right.data = val;
				}
				else{
					add(rootNode.right, val);
				}
			}
			else{
				if(rootNode.left == null){
					rootNode.left = new Node();
					rootNode.left.data = val;
				}
				else{
					add(rootNode.left, val);
				}
			}
		}

	}

	private class Node {
		int data;
		Node left, right;
	}
}

