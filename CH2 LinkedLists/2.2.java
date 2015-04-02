//implement an algorithm to find te kth to last element of a singly linked list
//recursive solutions are often clear but less optimal
public class Solution{
	public int kthtoLast(LinkedListNode head, int k){
		if (k < 0|| head == null)
			return -1;
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		//moving p2 to reach the position length - k.
		for(int i = 0; i< k - 1; i++)
		{
			p2 = p2.next;
		}
		//p1 and p2 are moving together
		while(p2.next != null)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}