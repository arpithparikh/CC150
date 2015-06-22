//write a code to remove duplicates from an unsorted array
//using hashtable, time complexity is O(n), space complexity is O(n)
/*
Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/
//time O(n) because we just iterate list once, space O(n),because using hashmap
import java.util.HashMap;
class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
public class Solution {

	private static ListNode arrayToLinkedList(int[] arr) {
		if (arr == null || arr.length < 1) return null;
		ListNode fakeHead = new ListNode(0);
		ListNode cur = fakeHead;
		for(int i = 0; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		return fakeHead.next;
	}
	
	private static boolean compareLinkedList(ListNode a, ListNode b) {
		ListNode p1 = a;
		ListNode p2 = b;
		while (p1 != null && p2 != null) {
			if (p1.val != p2.val) {
				return false;
			} else {
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		return p1 == null && p2 == null;
	}
	
	public static ListNode Solution(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode temp = dummy;
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		while(temp.next != null)
		{
			if(map.containsKey(temp.next.val))
			{
				ListNode tmp = temp.next.next;
				temp.next.next = null;
				temp.next = tmp;
				continue;
			}
			else
				map.put(temp.next.val,true);
			temp = temp.next;
		}
		return dummy.next;
	}
	
	
	public static void main(String[] args) {
		ListNode test1 = arrayToLinkedList(new int[]{1});
		ListNode test2 = arrayToLinkedList(new int[]{1, 2});
		ListNode test3 = arrayToLinkedList(new int[]{1, 2, 3, 3, 5, 5});
		ListNode test4 = arrayToLinkedList(new int[]{9, 312, 32, -2, 1, 32});
		ListNode test5 = arrayToLinkedList(new int[]{71, 32, 1, -32});
		ListNode test6 = arrayToLinkedList(new int[]{1, 1});
		ListNode test7 = null;
		ListNode test8 = arrayToLinkedList(new int[]{1, 1,1,1,1,1,1});
 
		System.out.println(compareLinkedList(Solution(test1), arrayToLinkedList(new int[]{1})));
		System.out.println(compareLinkedList(Solution(test2), arrayToLinkedList(new int[]{1,2})));
		System.out.println(compareLinkedList(Solution(test3), arrayToLinkedList(new int[]{1,2,3,5})));
		System.out.println(compareLinkedList(Solution(test4), arrayToLinkedList(new int[]{9,312,32,-2,1})));
		System.out.println(compareLinkedList(Solution(test5), arrayToLinkedList(new int[]{71,32,1,-32})));
		System.out.println(compareLinkedList(Solution(test6), arrayToLinkedList(new int[]{1})));
		System.out.println(compareLinkedList(Solution(test7), null));
		System.out.println(compareLinkedList(Solution(test8), arrayToLinkedList(new int[]{1})));	
	}
}

//if no buffer is allowed, we can use two pointer
//one is iterate whole list, the other is for check
//time complexity O(n2), space complexityO(1)
class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
public class Solution {

	private static ListNode arrayToLinkedList(int[] arr) {
		if (arr == null || arr.length < 1) return null;
		ListNode fakeHead = new ListNode(0);
		ListNode cur = fakeHead;
		for(int i = 0; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		return fakeHead.next;
	}
	
	private static boolean compareLinkedList(ListNode a, ListNode b) {
		ListNode p1 = a;
		ListNode p2 = b;
		while (p1 != null && p2 != null) {
			if (p1.val != p2.val) {
				return false;
			} else {
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		return p1 == null && p2 == null;
	}
	
	public static ListNode Solution(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode temp = head;
		while(temp!= null)
		{
			ListNode runner = temp;
			while(runner.next != null)
			{
			if(runner.next.val == temp.val)
				runner.next = runner.next.next;
			else
				runner = runner.next;
		    }
		    temp = temp.next;
		}
		return head;
	}
	
	
	
	public static void main(String[] args) {
		ListNode test1 = arrayToLinkedList(new int[]{1});
		ListNode test2 = arrayToLinkedList(new int[]{1, 2});
		ListNode test3 = arrayToLinkedList(new int[]{1, 2, 3, 3, 5, 5});
		ListNode test4 = arrayToLinkedList(new int[]{9, 312, 32, -2, 1, 32});
		ListNode test5 = arrayToLinkedList(new int[]{71, 32, 1, -32});
		ListNode test6 = arrayToLinkedList(new int[]{1, 1});
		ListNode test7 = null;
		ListNode test8 = arrayToLinkedList(new int[]{1, 1,1,1,1,1,1});
 
		System.out.println(compareLinkedList(Solution(test1), arrayToLinkedList(new int[]{1})));
		System.out.println(compareLinkedList(Solution(test2), arrayToLinkedList(new int[]{1,2})));
		System.out.println(compareLinkedList(Solution(test3), arrayToLinkedList(new int[]{1,2,3,5})));
		System.out.println(compareLinkedList(Solution(test4), arrayToLinkedList(new int[]{9,312,32,-2,1})));
		System.out.println(compareLinkedList(Solution(test5), arrayToLinkedList(new int[]{71,32,1,-32})));
		System.out.println(compareLinkedList(Solution(test6), arrayToLinkedList(new int[]{1})));
		System.out.println(compareLinkedList(Solution(test7), null));
		System.out.println(compareLinkedList(Solution(test8), arrayToLinkedList(new int[]{1})));	
	}
}