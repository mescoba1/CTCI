package LinkedList;

public class LinkedPalindrone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,2,1};
		LinkedList lst = new LinkedList();
		lst.addList(arr);
		lst.printList();
		System.out.println(lst.isPalindrone());
	}

}
