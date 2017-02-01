package LinkedList;

import LinkedList.LinkedList.Node;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1  = {6,3,1,9,7,2,1};
		int[] arr2  = {4,6,7,2,1};
		LinkedList a = new LinkedList();
		LinkedList b = new LinkedList();
		a.addList(arr1);
		b.addList(arr2);
		a.printList();
		b.printList();
		//Suppose to be by Reference, used Value for simplicity 
		Node intersect = findIntersect(a,b);
		if(intersect == null){
			System.out.println("No intersection found.");
		} else {
			System.out.println("Intersection at: " + intersect.data);
		}
	}
	public static Node findIntersect(LinkedList a, LinkedList b){
		if(a == null || b == null) return null;
		Node aTail = a.head, bTail = b.head;
		int aLen = 1, bLen = 1;
		
		while(aTail.next != null){
			aTail = aTail.next;
			aLen++;
		}
		while(bTail.next != null){
			bTail = bTail.next;
			bLen++;
		}
		
		if(aTail.data != bTail.data) return null;
		
		Node shortLst = aLen < bLen ? a.head : b.head;
		Node longLst = aLen > bLen ? a.head : b.head;
		int difference = Math.abs(aLen-bLen);
		
		for(int i =  0; i < difference; i++){
			if(longLst == null) return null;
			longLst = longLst.next;
		}
		
		while(shortLst.data != longLst.data){
			shortLst = shortLst.next;
			longLst = longLst.next;
		}
		
		return longLst;
	}
}
