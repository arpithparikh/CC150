//implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node
public class Solution{
	public void deleteMid(LinkedListNode n){
		if(n == null || n.next == null)
			return false;
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
}
//the problem cannot be solved if the node to be deleted is the last node in the linked list