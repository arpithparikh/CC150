//write a code to remove duplicates from an unsorted array
//using hashtable, time complexity is O(n), space complexity is O(n)
import java.util.Hashtable;
public class Solution1{
	public void deleteDuplicates(LinkedListNode n){
		if(n <= 0)
			return;
		Hashtable<Integer, boolean> res = new Hashtable<Integer, boolean>();
		LinkedListNode prev = null;
		while(n != null)
		{
			if (res.containsKey(n.data))
				prev.next = n.next;
			else
			{
				res.put(n.data, true);
				prev = n;
			}
			n = n.next;
		}
	}
}

//if no buffer is allowed, we can use two pointer
//one is iterate whole list, the other is for check
public class Solution2{
	public void deleteDuplicates(LinkedListNode head){
		if(head == null)
			return;
		LinkedListNode cur = head;
		while(cur != null)
		{
			LinkedListNode check = cur;
			if(check.next.data == cur.next.data)
				check.next = check.next.next;
			else
				check = check.next
		}
		cur = cur.next;
	}
}