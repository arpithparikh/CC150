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

// 时间复杂度：O(m+n)
// 空间复杂度：O(max(m,n))
import java.util.Stack;

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
			return l1== null?l2:l1;
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		ListNode dummy = null;
		while(l1!=null)
		{
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while(l2!=null)
		{
			stack2.push(l2.val);
			l2 = l2.next;
		}
		int carry = 0;
		while(!stack1.isEmpty() || !stack2.isEmpty())
		{
			int l1Value = stack1.isEmpty()?0:stack1.pop();
			int l2Value = stack2.isEmpty()?0:stack2.pop();
			ListNode temp = new ListNode((l1Value + l2Value + carry)%10);
			temp.next = dummy;
			dummy = temp;
			carry = (l1Value+l2Value+carry)/10;
		}
		if(carry ==1)
		{
			ListNode newNode = new ListNode(1);
			newNode.next = dummy;
			dummy = newNode;
		}
		return dummy;
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

		ListNode test6_1 = arrayToLinkedList(new int[]{2,1,2});
		ListNode test6_2 = null;
		
		System.out.println(compareLinkedList(Solution(test0_1,test0_2), null));
		System.out.println(compareLinkedList(Solution(test1_1,test1_2), arrayToLinkedList(new int[]{5,7,9})));
		System.out.println(compareLinkedList(Solution(test2_1,test2_2), arrayToLinkedList(new int[]{9,7,9})));
		System.out.println(compareLinkedList(Solution(test3_1,test3_2), arrayToLinkedList(new int[]{4,5,9,9})));
		System.out.println(compareLinkedList(Solution(test4_1,test4_2), arrayToLinkedList(new int[]{1,1,1,0})));
		System.out.println(compareLinkedList(Solution(test5_1,test5_2), arrayToLinkedList(new int[]{1,1,1})));
		System.out.println(compareLinkedList(Solution(test6_1,test6_2), arrayToLinkedList(new int[]{2,1,2})));
	}
		
}