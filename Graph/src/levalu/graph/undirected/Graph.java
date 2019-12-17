package levalu.graph.undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
	private static final int MAX_VERTICES = 20;
	private Vertex vertexList[];
	private int adjMatrix[][];
	private int vertexCount;
	public Graph(int maxVertex) {
		this.vertexCount = 0;
		vertexList = new Vertex[maxVertex];
		adjMatrix = new int[maxVertex][maxVertex];
		for(int i = 0; i < maxVertex; i++) {
			for(int j = 0; j < maxVertex; j++) {
				adjMatrix[i][j] = 0;
			}
		}
	}
	
	public Graph() {
		this(MAX_VERTICES);
	}
	
	public int getVertexCount() {
		return vertexCount;
	}

	public void addVertex(char lable) {
		vertexList[vertexCount] = new Vertex(lable);
		vertexCount++;
	}
	
	public void displayVertex(int position) {
		System.out.println(vertexList[position].getLable());
	}
	
	public void addEdge(int start, int end) {
		if((start >= 0 && start < vertexCount) && (end >= 0 && end < vertexCount)) {
			adjMatrix[start][end] = 1;
			adjMatrix[end][start] = 1;
		}
	}
	
	public void addEdge(int start, int end, int weight) {
		addEdge(start, end);
	}
	
	public void removeEdge(int i, int j) {
		if((i >= 0 && i < vertexCount) && (j >= 0 && j < vertexCount)) {
			adjMatrix[i][j] = 0;
			adjMatrix[j][i] = 0;
		}
	}
	
	public boolean isEdge(int start, int end) {
		if((start >= 0 && end < vertexCount) && (start >= 0 && end < vertexCount)) {
			return adjMatrix[start][end] > 0;
		} else {
			return false;
		}
	}
	
	// The time complexity : O(V^2) for adjacency matrix representation
	public void traversalDepthFirstSearch() {
		Stack<Integer> stack = new Stack<>();
		vertexList[0].setVisited(true);
		displayVertex(0);
		stack.push(0);
		while(!stack.isEmpty()) {
			// Get an unvisited vertex adjacent to stack top's node position
			int position = getAdjUnvisitedVertex(stack.peek());
			if(position == -1) {
				stack.pop();
			} else {
				vertexList[position].setVisited(true);
				displayVertex(position);
				stack.push(position);
			}
		
		}
		
		// Reset all vertices to unvisited
		for(int i = 0; i < vertexCount; i++) {
			vertexList[i].setVisited(false);
		}
	}
	
	// The time complexity : O(V^2) for adjacency matrix representation
	public void traversalBreadthFirstSearch() {
		Queue<Integer> queue = new LinkedList<>();
		vertexList[0].setVisited(true);
		displayVertex(0);
		queue.offer(0);
		int vertexTwo;
		while(!queue.isEmpty()) {
			int vertexOne = queue.poll();
			while((vertexTwo = getAdjUnvisitedVertex(vertexOne)) != -1) {
				vertexList[vertexTwo].setVisited(true);
				displayVertex(vertexTwo);
				queue.offer(vertexTwo);
			}
		}
		
		// Reset all vertices to unvisited
		for(int i = 0; i < vertexCount; i++) {
			vertexList[i].setVisited(false);
		}
	}
	
	// Get the next adjacent vertices of the current vertex
	public int getAdjUnvisitedVertex(int position) {
		for(int i = 0; i < vertexCount; i++) {
			if(adjMatrix[position][i] == 1 && vertexList[i].isVisited() == false) {
				return i;
			}
		}
		return -1;
	}
}
