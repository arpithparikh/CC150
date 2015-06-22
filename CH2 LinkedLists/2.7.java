//is valid palindrome
//reverse and compare, time complexity O(n), space complexity O(n), iterative
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



	public static boolean Solution(ListNode head){
		if(head == null)
			return true;
		if(head.next == null)
			return true;
		Stack<Integer> stack1 = new Stack<Integer>();
		ListNode fakeHead = head;
		while(fakeHead != null)
		{
			stack1.push(fakeHead.val);
			fakeHead = fakeHead.next;
		}
		while(!stack1.isEmpty())
		{
			int temp = stack1.pop();
			if(temp == head.val)
				head = head.next;
			else
				return false;
		}
		return true;
	}



	public static void main(String[] args) {	
		
		ListNode test0 = null;		
		ListNode test1 = arrayToLinkedList(new int[]{1});
		ListNode test2 = arrayToLinkedList(new int[]{20,10,20});
		ListNode test3 = arrayToLinkedList(new int[]{1,2,3,4,5,4,3,2,1});
		ListNode test4 = arrayToLinkedList(new int[]{2,2,2});
		ListNode test5 = arrayToLinkedList(new int[]{-5,2,4,0,-7,-6,1,9,-10,12});
		ListNode test6 = arrayToLinkedList(new int[]{2,3,4,2,1});
		
		System.out.println(Solution(test0));
		System.out.println(Solution(test1));
		System.out.println(Solution(test2));
		System.out.println(Solution(test3));
		System.out.println(Solution(test4));
		System.out.println(Solution(test5));
		System.out.println(Solution(test6));
		
	}		
}

//recursive approach, time complexity O(n), space complexity O(n)
package CC150;

import java.util.ArrayList;

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

	

	public static boolean Solution(ListNode head){
		if(head == null||head.next == null)
			return true;
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ListNode temp = head;
		while(temp.next!= null)
		{
			list1.add(temp.val);
			temp = temp.next;
		}
		helper(head, list2);
		for(int i =0;i<list1.size();i++)
		{
			if(list2.get(i)!= list1.get(i))
				return false;
		}
		return true;
	}
	private static void helper(ListNode head, ArrayList<Integer> list){
		if(head == null)
			return;
		helper(head.next, list);
		list.add(head.val);
		return;
	}



	public static void main(String[] args) {	
		
		ListNode test0 = null;		
		ListNode test1 = arrayToLinkedList(new int[]{1});
		ListNode test2 = arrayToLinkedList(new int[]{20,10,20});
		ListNode test3 = arrayToLinkedList(new int[]{1,2,3,4,5,4,3,2,1});
		ListNode test4 = arrayToLinkedList(new int[]{2,2,2});
		ListNode test5 = arrayToLinkedList(new int[]{-5,2,4,0,-7,-6,1,9,-10,12});
		ListNode test6 = arrayToLinkedList(new int[]{2,3,4,2,1});
		
		System.out.println(Solution(test0));
		System.out.println(Solution(test1));
		System.out.println(Solution(test2));
		System.out.println(Solution(test3));
		System.out.println(Solution(test4));
		System.out.println(Solution(test5));
		System.out.println(Solution(test6));
		
	}		
}