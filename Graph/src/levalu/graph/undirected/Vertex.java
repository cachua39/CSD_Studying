package levalu.graph.undirected;

import java.util.Comparator;

public class Vertex{
	private char lable;
	private boolean visited;

	public Vertex(char lable) {
		this.lable = lable;
		visited = false;
	}

	public char getLable() {
		return lable;
	}

	public void setLable(char lable) {
		this.lable = lable;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
