//Given a circular linked list, implement an algorithm which returns the node at the begining of the loop
public class Solution{
	public LinkedListNode findBegining(LinkedListNode head){
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		while(fast != null || fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow)
				break;
		}
		slow = head;
		while(slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}