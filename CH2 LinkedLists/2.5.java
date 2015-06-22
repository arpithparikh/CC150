/*
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, 
such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295.
Output: 2 -> 1 -> 9.That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
Input:(6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
Output: 9 -> 1 -> 2.That is, 912.
*/
//时间复杂度O（m+n），空间复杂度 O（max（m,n））
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

	public static ListNode Solution(ListNode l1, ListNode l2){
		if(l1 == null || l2 == null)
			return l1==null?l2:l1;
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;
		int carry = 0;
		while(l1 != null || l2 != null)
		{
			int l1Value = l1==null?0:l1.val;
			int l2Value = l2 ==null?0:l2.val;
			ListNode tmp = new ListNode((l1Value+l2Value+carry)%10);
			carry = (l1Value + l2Value+carry)/10;
			temp.next = tmp;
			temp = temp.next;
			l1 = l1==null?l1:l1.next;
			l2 = l2==null?l2:l2.next;
		}
		if(carry ==1)
		{
			ListNode newNode = new ListNode(1);
			temp.next = newNode;
		}
		return dummy.next;
	}



	public static void main(String[] args) {		
		ListNode test0_1 = null;		
		ListNode test0_2 = null;	
		
		ListNode test1_1 = arrayToLinkedList(new int[]{1,2,3});
		ListNode test1_2 = arrayToLinkedList(new int[]{4,5,6});
		
		ListNode test2_1 = arrayToLinkedList(new int[]{5,6});
		ListNode test2_2 = arrayToLinkedList(new int[]{9,2,3});
		
		
		ListNode test3_1 = arrayToLinkedList(new int[]{4,5,8,7});
		ListNode test3_2 = arrayToLinkedList(new int[]{1,2});
		
		ListNode test4_1 = arrayToLinkedList(new int[]{9,9,9});
		ListNode test4_2 = arrayToLinkedList(new int[]{1,1,1});
		
		ListNode test5_1 = null;
		ListNode test5_2 = arrayToLinkedList(new int[]{1,1,1});		

		ListNode test6_1 = arrayToLinkedList(new int[]{0,1,2});
		ListNode test6_2 = null;
		
		System.out.println(compareLinkedList(Solution(test0_1,test0_2), null));
		System.out.println(compareLinkedList(Solution(test1_1,test1_2), arrayToLinkedList(new int[]{5,7,9})));
		System.out.println(compareLinkedList(Solution(test2_1,test2_2), arrayToLinkedList(new int[]{4,9,3})));
		System.out.println(compareLinkedList(Solution(test3_1,test3_2), arrayToLinkedList(new int[]{5,7,8,7})));
		System.out.println(compareLinkedList(Solution(test4_1,test4_2), arrayToLinkedList(new int[]{0,1,1,1})));
		System.out.println(compareLinkedList(Solution(test5_1,test5_2), arrayToLinkedList(new int[]{1,1,1})));
		System.out.println(compareLinkedList(Solution(test6_1,test6_2), arrayToLinkedList(new int[]{0,1,2})));
	}
		
}
//=========
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