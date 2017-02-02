package Graphs;

import java.util.*;

public class Graph {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge('A', 'B');
		g.addEdge('A', 'C');
		g.addEdge('B', 'D');
		g.addEdge('B', 'E');
		g.addEdge('C', 'F');
		g.addEdge('F', 'G');
		g.addEdge('E', 'D');
		g.addEdge('E', 'F');
		g.addEdge('D', 'G');
		g.addEdge('G', 'H');
		g.addEdge('H', 'I');
		g.topoSort('A');
	}

	ArrayList<Node> nodes;
	Stack<Node> finished;

	public Graph() {
		this.nodes = new ArrayList<Node>();
		finished = new Stack<Node>();
	}

	public void topoSort(Object o) {
		int discoverTime = 0;
		Node current = getNode(o);
		topoHelper(current, discoverTime);
		while (!finished.isEmpty()) {
			System.out.print(finished.pop() + ", ");
		}
		System.out.println();
	}

	public void topoHelper(Node n, int time) {
		ArrayList<Node> edges = n.getEdges();
		int t = time;
		// Potential Bug, Base Case
		if (n.getEdges().isEmpty()) {
			n.setFinishTime(t);
			finished.push(n);
			return;
		}
		// Itterate the edges and visit
		for (Node e : edges) {
			// Only visit is it has not finished
			if (e.getFinishTime() == -1) {
				topoHelper(e, t++);
			}
		}
		finished.push(n);
		n.setFinishTime(t);
	}

	public void printNodes() {
		for (Node e : nodes) {
			System.out.print(e.val + ",");
		}
		System.out.println();
	}

	public void addNode(Node n) {
		this.nodes.add(n);
	}

	public Node getNode(Object o) {
		for (Node n : nodes) {
			if (n.val == o) {
				return n;
			}
		}
		return null;
	}

	public void addEdge(Object me, Object you) {
		Node a = getNode(me);
		if (a == null) {
			a = new Node(me);
			addNode(a);
			a = getNode(me);
		}
		Node b = getNode(you);
		if (b == null) {
			b = new Node(you);
			addNode(b);
			b = getNode(you);
		}
		a.addEdge(b);
		/*This a DAG silly billy*/
		//b.addEdge(a);
	}

	class Node {
		Object val;
		int finish;
		ArrayList<Node> edges;

		public Node(Object val) {
			this.val = val;
			this.edges = new ArrayList<Node>();
			this.finish = -1;
		}

		public void addEdge(Node n) {
			this.edges.add(n);
		}

		public Node getEdge(Object val) {
			for (Node e : edges) {
				if (e.val == val) {
					return e;
				}
			}
			return null;
		}

		public int getFinishTime() {
			return finish;
		}

		public void setFinishTime(int f) {
			this.finish = f;
		}

		public ArrayList<Node> getEdges() {
			return edges;
		}

		public void printEdges() {
			for (Node e : edges) {
				System.out.print(e.val + ",");
			}
			System.out.println();
		}

		public String toString() {
			return ((char) val)+ "";
		}
	}
}
