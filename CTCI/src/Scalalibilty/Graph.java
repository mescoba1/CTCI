package Scalalibilty;

import java.util.*;

public class Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ArrayList<Node> nodes;

	public Graph() {
		this.nodes = new ArrayList<Node>();
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

	/* DOESNT WORK, figure out later.. */
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
		b.addEdge(a);
	}

	public void findPath(Object a, Object b) {
		Node me = getNode(a), you = getNode(b);
		if (me == null || you == null) {
			System.out.println("One of nodes not found.");
			return;
		}
		Queue<Node> s = new LinkedList<Node>();
		s.add(me);
		System.out.println("Finding..");
		HashMap<Node, Boolean> visited = new HashMap<Node, Boolean>();
		while(!s.isEmpty()){
			Node current = (Node) s.remove();
			System.out.print(current.val+"->");
			if(current == you){
				System.out.println("Done!");
				return;
			}
			visited.put(current, true);
			addChildrenToStack(s, current.getEdges(), visited);
			//System.out.println(s);
		}
	}
	public void addChildrenToStack(Queue s, ArrayList<Node> edges, HashMap<Node,Boolean> visited){
		for(Node e : edges){
			if(visited.get(e) == null)
				s.add(e);
		}
	}
	class Node {
		Object val;
		ArrayList<Node> edges;

		public Node(Object val) {
			this.val = val;
			this.edges = new ArrayList<Node>();
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
		public ArrayList<Node> getEdges(){
			return edges;
		}
		public void printEdges() {
			for (Node e : edges) {
				System.out.print(e.val + ",");
			}
			System.out.println();
		}
		public String toString(){
			return (String) val;
		}
	}
}
