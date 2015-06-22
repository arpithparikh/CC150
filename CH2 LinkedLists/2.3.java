//implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node
//time 0(1), space O(1)
class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
public class Test {
	
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode middle = node3, head = node1;
		ListNode crtPointer = head;
		while(crtPointer!=null){
			System.out.print(crtPointer.val+"	");
			crtPointer = crtPointer.next;
		}
		System.out.println("");
		System.out.println("After Delete.");
		Solution(middle);
		crtPointer = head;
		while(crtPointer!=null){
			System.out.print(crtPointer.val+"	");
			crtPointer = crtPointer.next;
		}		
	}
	
	public static void Solution(ListNode middle){
		if(middle == null || middle.next == null)
			return;
		ListNode next = middle.next;
		middle.val = next.val;
		middle.next = next.next;
		return;
	}	
}

//the problem cannot be solved if the node to be deleted is the last node in the linked list