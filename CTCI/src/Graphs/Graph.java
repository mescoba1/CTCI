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
		Node current = getNode(o);
		topoHelper(current);
		while (!finished.isEmpty()) {
			System.out.print(finished.pop() + ", ");
		}
		System.out.println();
	}

	public void topoHelper(Node n) {
		ArrayList<Node> edges = n.getEdges();
		// Potential Bug, Base Case
		if (n.getEdges().isEmpty()) {
			n.setFinished();
			finished.push(n);
			return;
		}
		// Itterate the edges and visit
		for (Node e : edges) {
			// Only visit is it has not finished
			if (!e.isFinished()) {
				topoHelper(e);
			}
		}
		finished.push(n);
		n.setFinished();
	}

	public void dijkstras(Object o) {
		Node source = getNode(o);
		// Everwhere but source is set to INFINITY
		PriorityQueue<Node> pQ = new PriorityQueue<Node>();
		for (Node n : nodes) {
			if (n != source) {
				n.setDist(Integer.MAX_VALUE);
			}
			pQ.add(n);
		}
		while (!pQ.isEmpty()) {
			source = pQ.poll();
			// Relax Edges
			for (Node e : source.getEdges()) {
				if (e.dist > source.dist + source.getWeight(e)) {
					pQ.remove(e);
					e.setDist(source.dist + source.getWeight(e));
					pQ.add(e);

				}
			}
		}
		System.out.println("Distance from " + source + ":");
		for (Node n : nodes) {
			System.out.println(n + "->" + n.dist);
		}
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
		/* This a DAG silly billy */
		// b.addEdge(a);
	}

	public void addEdge(Object me, Object you, int cost) {
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
		a.addEdge(b, cost);
	}

	class Node implements Comparable<Node> {
		Object val;
		boolean finished;
		ArrayList<Integer> weights;
		ArrayList<Node> edges;
		int dist;

		public Node(Object val) {
			this.val = val;
			this.edges = new ArrayList<Node>();
			this.weights = new ArrayList<Integer>();
			this.finished = false;
			dist = 0;
		}

		public Node(Object val, int dist) {
			this.val = val;
			this.edges = new ArrayList<Node>();
			this.weights = new ArrayList<Integer>();
			this.finished = false;
			this.dist = dist;
		}

		public void addEdge(Node n) {
			this.edges.add(n);
		}

		public void addEdge(Node n, int w) {
			this.edges.add(n);
			this.weights.add(w);
		}

		public Node getEdge(Object val) {
			for (Node e : edges) {
				if (e.val == val) {
					return e;
				}
			}
			return null;
		}

		public boolean isFinished() {
			return finished;
		}

		public void setFinished() {
			this.finished = true;
		}

		public ArrayList<Node> getEdges() {
			return edges;
		}

		public int getWeight(Node n) {
			int index = edges.indexOf(n);
			return weights.get(index);
		}

		public void printEdges() {
			for (Node e : edges) {
				System.out.print(e.val + ",");
			}
			System.out.println();
		}

		public String toString() {
			return ((char) val) + "";
		}

		public void setDist(int d) {
			this.dist = d;
		}

		public boolean equals(Node n) {
			return this.dist == n.dist;
		}

		public int compareTo(Node other) {
			// 0 equal 1 bigger -1 smaller
			if (this.equals(other)) {
				return 0;
			}
			if (this.dist > other.dist) {
				return 1;
			}
			return -1;
		}

	}
}
