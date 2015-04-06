public class Solution{
	public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, LinkedListNode result){
		int carry = 0;
		LinkedListNode result = null;
		LinkedListNode res = null;
		while(l1 != null || l2 != null)
		{
			if(l1 + l2 - 10 < 0)
			{
				result.data = (l1.data + l2.data) % 10;
				res.setNext(result);
			}
			else{
				carry = 1;
				result.data = (l1.data + l2.data+carry) % 10;
				res.setNext(result);
			}
			l1 = l1.next;
			l2 = l2.next;
			result = result.next;
			if(l1.next == null || l2.next == null || (l1.data + l2.data + carry)>10)
			{
				result.data = (l1.data + l2.data+carry) % 10;
				LinkedListNode next = result.next;
				next.data = 1;
				next.next = null;
				res.setNext(next);
			}

		}
		return res;
	}
}