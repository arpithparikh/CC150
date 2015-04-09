//is valid palindrome
//reverse and compare, time complexity O(n), space complexity O(n)
public class Solution1{
	public boolean isValidPalindrome(LinkedListNode head){
		LinkedListNode l1 = head;
		LinkedListNode l2 = head;
		while(l1 != null && l1.next != null)
		{
			LinkedListNode before = new LinkedListNode;
			before.next = l2;
			before.data = l1.next.data;
			l1 = l1.next;
			l2 = before;
		}
		while( l1 != null || l1.next != null)
		{
			if(l1.data == l2.data)
			{
				l1 = l1.next;
				l2 = l2.next;
			}
			return true;
		}
		return false;
	}
}
//Iterative approach, time complexity O(n), space complexity O(n)
public class Solution2{
	public boolean isValidPalindrome(LinkedListNode head){
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		Stack<Integer> res = new Stack<Integer>();
		while(fast != null || fast.next != null)
		{
			res.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		//if odd number, skip
		if(fast != null)
			slow = slow.next;
		while(slow != null)
		{
			//The Object returned by l.get(i) is an instance of the Integer class.
			//intValue() is a instance method of the Integer class that returns a primitive int.
			int top = res.pop().intValue();
			if(top != slow.data)
				return false;
			slow = slow.next;
		}
		return true;
	}
}