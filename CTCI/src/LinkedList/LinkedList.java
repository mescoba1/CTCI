package LinkedList;

import java.util.*;

public class LinkedList {
	Node head;

	public void addNode(int val) {
		if (this.head == null) {
			this.head = new Node(val);
			return;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(val);
		}
	}

	public void addList(int[] arr) {
		for (int x : arr) {
			this.addNode(x);
		}
	}

	class Node {
		int data;
		Node next;

		public Node(int val) {
			this.data = val;
			this.next = null;
		}

		public void addNode(Node n) {
			this.next = n;
		}
	}

	public void printList() {
		Node temp = head;
		System.out.print(temp.data + "->");
		while (temp.next != null) {
			temp = temp.next;
			System.out.print(temp.data + "->");
		}
		System.out.println();
	}

	public void removeDups() {
		HashSet t = new HashSet();
		Node temp = this.head;
		Node prev = this.head;
		boolean removeLast = false;
		while (temp.next != null) {
			if (!t.contains(temp.data)) {
				t.add(temp.data);
			} else {
				System.out.println("Removing " + temp.data);
				prev.next = temp.next;
				temp = prev.next;
				continue;
			}
			prev = temp;
			temp = temp.next;
		}
		if (t.contains(temp.data)) {
			prev.next = null;
		}
	}

	public boolean isPalindrone() {
		Node fast = this.head;
		Node slow = this.head;
		Stack<Integer> st = new Stack();
		// add first half list to stack
		while (fast != null && fast.next != null) {
			st.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		// we have odd # of items
		if (fast != null) {
			//skip the middle element
			slow = slow.next;
		}
		
		//itterate through rest of list
		while(slow.next != null){
			if(slow.data != st.pop()){
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}
