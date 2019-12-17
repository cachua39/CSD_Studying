package levalu.graph.undirected;

public class GraphDemo {
	public static void main(String args[]) {
		Graph graph = new Graph();
		graph.addVertex('a'); 	//0
		graph.addVertex('d');	//1
		graph.addVertex('e');	//2
		graph.addVertex('h');	//3
		graph.addVertex('f');	//4
		graph.addVertex('i');	//5
		
		graph.addEdge(0, 2, 1);
		graph.addEdge(0, 3, 10);
		graph.addEdge(1, 0, 4);
		graph.addEdge(1, 3, 1);
		graph.addEdge(3, 2, 5);
		graph.addEdge(2, 4, 3);
		graph.addEdge(3, 5, 9);
		graph.addEdge(4, 5, 1);
		
	}
}
