package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	public static void main(String[] args) {
		Graph obj = new Graph();
		int fromList[] = {1, 2, 4};
		int toList[] = {2, 3, 5};
		int n=5;
		/*
		  	1 - 2 - 3 

		  	4 - 5
		 */
		
		Node []graph = obj.createGraph(n, fromList, toList);
		for(int currNode=1; currNode<graph.length; currNode++){
			obj.printGraph(graph[currNode], currNode);
			System.out.println();
		}
		int start = 2;
		int end = 5;
		boolean []visited = new boolean[graph.length];
		System.out.println();
		System.out.println("Max Size : " + obj.maxSize(graph));
		System.out.println();
		System.out.println("Conn. Comp. : " + obj.connectedComponents(graph));
		System.out.println();
		System.out.println("BFS : " + obj.bfs(graph, start, visited));
		System.out.println();
		System.out.print("Find path : ");
		obj.findPath(graph, start, end);
		System.out.println();
		System.out.println();
		System.out.println("Find Distance : ");
		obj.findDistance(graph, start);
	}

	public void printGraph(Node firstNode, int node) {
		Node currNode = firstNode;
		System.out.print(node + ": ");
		while(currNode!=null){
			System.out.print(currNode.val + " ");
			currNode = currNode.next;
		}
	}

	public int bfs(Node []graph, int start, boolean []visited) {

		// 1 -- 2, start = 1
		//boolean []visited = new boolean[graph.length];
		int []parent = new int[graph.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(start); // 1
		visited[start] = true;
		int size = 1;
		while (!q.isEmpty()) {
			int currentNode = q.remove();
			Node curr = graph[currentNode];
			while(curr != null) {
				if (!visited[curr.val]) {
					size++;
					visited[curr.val] = true;
					parent[curr.val] = currentNode;
					q.add(curr.val);
				}
				curr = curr.next;
			}
		}
		return size;
	}

	public void bfs_1(Node []graph, int start, boolean []visited, int[] parent) {
		// 1 -- 2, start = 1
		//boolean []visited = new boolean[graph.length];
		//int []parent = new int[graph.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(start); // 1
		visited[start] = true;
		//int size = 1;
		while (!q.isEmpty()) {
			int currentNode = q.remove();
			Node curr = graph[currentNode];
			while(curr != null) {
				if (!visited[curr.val]) {
					// size++;
					visited[curr.val] = true;
					parent[curr.val] = currentNode;
					q.add(curr.val);
				}
				curr = curr.next;
			}
		}
		//return size;
	}


	/*
	        All the vertices are represented by 1 to n.
	 */
	public void findPath(Node []graph, int start, int end) {
		boolean []visited = new boolean[graph.length];
		int []parent = new int[graph.length];
		bfs_1(graph, start, visited, parent);
		printPath(start, end, parent);            
	}

	/*
	        Input Graph: 1-2-3
	        start = 1, end = 3
	        parent[] = {0, 0, 1, 2}
	        O/P: 1 2 3
	        start    end
	        1    3
	        1    2
	        1    1

	 */
	private void printPath(int start, int end, int[]parent) {
		if (end == 0) {
			return;
		}        
		printPath(start, parent[end], parent);
		System.out.print(end + " ");
	}

	/*
	        Returns distance between start node and every other node in the graph. 
	        BFS is used to compute shortest path or distance in case of graphs with same weights.
	 */
	public void findDistance(Node[] graph, int start) {
		int []distance = bfs_2(graph, start);
		for (int i=1; i<distance.length; i++) {
			System.out.println(start + " to " + i + " takes " + distance[i] + " steps."); 
		}
	}

	public int[] bfs_2(Node []graph, int start) {
		// 1 -- 2, start = 1
		boolean []visited = new boolean[graph.length];
		int []distance = new int[graph.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(start); // 1
		visited[start] = true;
		while (!q.isEmpty()) {
			int currentNode = q.remove();
			Node curr = graph[currentNode];
			int distanceSoFar = distance[currentNode];
			while(curr != null) {
				if (!visited[curr.val]) {
					//size++;
					visited[curr.val] = true;
					//parent[curr.val] = currentNode;
					distance[curr.val] = distanceSoFar + 1;
					q.add(curr.val);
				}
				curr = curr.next;
			}
		}
		return distance;
	}


	public int connectedComponents(Node[] graph) {
		boolean[] visited = new boolean[graph.length];
		int components = 0;
		for (int currentNode=1; currentNode<graph.length; currentNode++) {
			if (!visited[currentNode]) {
				bfs(graph, currentNode, visited);
				components++;
			}
		}
		return components;
	}

	public int maxSize(Node[] graph){
		boolean[] visited = new boolean[graph.length];
		int max = 0;
		for(int currNode=1; currNode<graph.length; currNode++){
			if(!visited[currNode]){
				int size = bfs(graph, currNode, visited);
				if(size>max){
					max = size;
				}
			}
		}
		return max;

	}

	public Node[] createGraph(int n, int []fromList, int []toList) {
		Node []nodeArr = new Node[n+1];
		for (int i=0; i<fromList.length; i++) {
			int from = fromList[i];
			int to = toList[i];
			Node node_from = new Node(from);//2
			Node node_to = new Node(to);//4
			// add node_from in 'to' list
			if (nodeArr[to] == null) {
				nodeArr[to] = node_from;
			} else {
				node_from.next = nodeArr[to];
				nodeArr[to] = node_from;
			}
			// add node_to in 'from' list
			if(nodeArr[from] == null){
				nodeArr[from] = node_to;
			} else{
				node_to.next = nodeArr[from];
				nodeArr[from] = node_to;
			}
		}
		return nodeArr;
	}

	private static class Node {
		int val;
		Node next;

		public Node(int v) {
			val = v;
		}
	}


}
