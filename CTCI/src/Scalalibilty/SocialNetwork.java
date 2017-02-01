package Scalalibilty;

import java.util.*;
import Scalalibilty.Facebook.Node;

public class SocialNetwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Graph sn= new Graph();
		sn.addEdge("Me", "Bob");
		sn.addEdge("Me", "Tim");
		sn.addEdge("Me", "Bill");
		sn.addEdge("Tim", "Sally");
		sn.addEdge("Sally", "You");
		sn.addEdge("You", "Miguel");
		sn.addEdge("Jose", "Miguel");
		sn.addEdge("Jose", "Bob");
		//sn.getNode("You").printEdges();
		//sn.getNode("Sally").printEdges();
		//sn.getNode("Jose").printEdges();
		//Me->Tim->Sally->You
		sn.findPath("Me","You");*/
		Facebook fb = new Facebook();
		fb.addUser("Me"); //0
		fb.addUser("Bob"); //1
		fb.addUser("Tim"); //2
		fb.addUser("Bill"); //3
		fb.addUser("Sally"); //4
		fb.addUser("You"); //5
		fb.addUser("Miguel"); //6
		fb.addConnection(0, 1);
		fb.addConnection(0, 2);
		fb.addConnection(0, 3);
		fb.addConnection(2, 4);
		fb.addConnection(4, 5);
		fb.addConnection(5, 6);
		//fb.printFriends(5);
		LinkedList<Node> order = fb.findConnection(0, 5);
		System.out.println(order);
	}

}
