//implement an algorithm to find te kth to last element of a singly linked list
//recursive solutions are often clear but less optimal
//time O(n), space O(1)
class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
public class Solution {
	
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		ListNode head = node1;
		System.out.println(Solution(head,1));

	}
	
	public static int Solution(ListNode head, int k){
		if(head == null || k <0)
			return -1;
		ListNode fast = head;
		ListNode slow = head;
		for(int i =0;i<k-1;i++)//如果找倒数第k个，那么就是k-1，如果要找到倒数第k+1个，那么就是k
			fast = fast.next;
		while(fast.next!= null)
		{
			slow = slow.next;
			fast = fast.next;
		}
		return slow.val;
	}
}