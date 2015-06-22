/*
同Leetcode #142	Linked List Cycle II
Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, 
so as to make a loop in the linked list.
EXAMPLE
Input:A ->B->C->D->E-> C[the same C as earlier] 
Output:C
*/
//Given a circular linked list, implement an algorithm which returns the node at the begining of the loop
//time O(n), space O(1)
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

	public static ListNode Solution(ListNode head){
		if(head == null || head.next == null || head.next.next == null)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!= null)
		{
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				break;
		}
		slow = head;
		while(slow!=fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}



	public static void main(String[] args) {	
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2); n1.next = n2;
		ListNode n3 = new ListNode(3); n2.next = n3;
		ListNode n4 = new ListNode(4); n3.next = n4;
		ListNode n5 = new ListNode(5); n4.next = n5;
		n5.next = n3;
		ListNode head1 = n1;
		System.out.println( Solution(head1) == n3 );

		ListNode n11 = new ListNode(1);
		ListNode n22 = new ListNode(2); n11.next = n22;
		ListNode n33 = new ListNode(3); n22.next = n33;
		n33.next = n33;
		ListNode head11 = n11;
		System.out.println( Solution(head11) == n33 );

		ListNode n111 = new ListNode(1);
		n111.next = n111;
		ListNode head111 = n11;
		System.out.println( Solution(head111) == n111 );
			
	}		
}

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