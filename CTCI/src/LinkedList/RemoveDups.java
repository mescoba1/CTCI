package LinkedList;

public class RemoveDups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hash each node to a list
		//if node is hash then delete
		int[] arr = {1,2,7,4,8,2,7,4,9,7,2};
		LinkedList lst = new LinkedList();
		for(int x : arr){
			lst.addNode(x);
		}
		lst.printList();
		lst.removeDups();
		lst.printList();
	}
}
