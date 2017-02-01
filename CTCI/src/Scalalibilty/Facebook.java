package Scalalibilty;
import java.util.*;

public class Facebook {
	HashMap<Integer, Person> fb;
	int users;
	public Facebook(){
		fb = new HashMap<>();
		users = 0;
	}
	public LinkedList<Node> findConnection(int a, int b){
		BFS start = new BFS(fb.get(a));
		BFS dest = new BFS(fb.get(b));
		
		while(!start.isFinished() && !dest.isFinished()){
			Person collision = searchLayer(start, dest);
			if(collision != null){
				return mergeNodes(start, dest, collision.getID());
			}   
			collision = searchLayer(dest, start);
			if(collision != null){
				return mergeNodes(start, dest, collision.getID());
			}
		}
		
		return null;
		
	}
	public LinkedList<Node> mergeNodes(BFS source, BFS dest, int ID){
		Stack<Node> s = new Stack<Node>();
		Node intersect = source.visited.get(ID);
		while(intersect != null){
			s.push(intersect);
			intersect = intersect.prev;
			
		}
		LinkedList<Node> ordered = new LinkedList<>();
		while(!s.isEmpty()){
			ordered.add(s.pop());
		}
		intersect = dest.visited.get(ID);
		while(intersect.prev !=null){
			intersect = intersect.prev;
			ordered.add(intersect);
		}
		return ordered;
	}
	public Person searchLayer(BFS start, BFS dest){
		int numNodes = start.toVisit.size();
		for(int i = 0; i < numNodes; i++){
			Node primary = start.toVisit.poll();
			int personID = primary.getPerson().getID();
			
			//check its been visited	
			if(dest.visited.containsKey(personID)){
				return primary.getPerson();
			}
			//add friends to queue
			for(int id : fb.get(personID).getFriends()){
				if(!start.visited.containsKey(id)){
					Person friend = fb.get(id);
					Node next = new Node(friend, primary);
					start.toVisit.add(next);
					start.visited.put(id, next);
				}
			}	
		}
		return null;
	}

	public void addUser(String name){
		Person p = new Person(name,users++);
		fb.put(p.id, p);
	}
	public Person getUser(int id){
		return fb.get(id);
	}
	public void printFriends(int id){
		Person p = getUser(id);
		ArrayList<Integer> friends = p.getFriends();
		for(Integer friendID : friends){
			System.out.print(fb.get(friendID).name + ", ");
		}
		System.out.println();
	}
	public void addConnection(int a, int b){
		Person me = getUser(a), you = getUser(b);
		me.addFriend(you.getID());
		you.addFriend(me.getID());
	}
	public class Person{
		String name;
		int id;
		ArrayList<Integer> friends;
		public Person(String n, int id){
			friends = new ArrayList<Integer>();
			this.name = n;
			this.id = id;
		}
		public String toString(){
			return name;
		}
		public void addFriend(int id){
			friends.add(id);
		}
		public ArrayList<Integer> getFriends(){
			return friends;
		}
		public int getID(){
			return id;
		}
	}
	public class BFS {
		HashMap<Integer, Node> visited = new HashMap<>();
		Queue<Node> toVisit = new LinkedList<Node>();
		
		public BFS(Person root){
			Node source = new Node(root, null);
			this.toVisit.add(source);
			visited.put(source.p.getID(), source);	
		}
		public boolean isFinished(){
			return toVisit.isEmpty();
		}
	}
	public class Node {
		Person p;
		Node prev;
		public Node(Person p, Node prev){
			this.p = p;
			this.prev = prev;
		}
		public Person getPerson(){
			return p;
		}
		public String toString(){
			return p.toString();
		}
	}
	/*public void findConnection(int a, int b){
	//find shortest distance from me to you
	Person me = getUser(a), you = getUser(b);
	if(me == null || you == null){
		System.out.println("One of users not found.");
		return;
	}
	Queue<Integer> toVisit = new LinkedList<Integer>();
	HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
	toVisit.add(me.getID());
	visited.put(me.getID(), true);
	while(!toVisit.isEmpty()){
		Integer current = toVisit.poll();
		System.out.print(fb.get(current) + "->");
		if(fb.get(current).getID() == you.getID()){
			System.out.println("Done!");
			return;
		}
		visited.put(current, true);
		ArrayList<Integer> friendIDs = fb.get(current).getFriends();
		for(Integer id : friendIDs){
			if(!visited.containsKey(id)){
				toVisit.add(id);
			}
		}
	}
}*/
}
