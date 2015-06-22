//write a code to partition a linked list around the value x, 
//such that all nodes less than x come before all nodes greater than or equal to x
//
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

	public static ListNode Solution(ListNode head, int x){
		if(head == null || head.next == null)
			return head;
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode dummy11 = dummy1;
		ListNode dummy22 = dummy2;
		while(head != null)
		{
			if(head.val < x){
				dummy11.next = head;
				dummy11 = dummy11.next;
			}
			else{
				dummy22.next = head;
				dummy22 = dummy22.next;
			}
			head = head.next;
		}
		dummy22.next = null;
		dummy11.next = dummy2.next;
		return dummy1.next;
	}


	public static void main(String[] args) {		
		ListNode test0 = null;		
		ListNode test1 = arrayToLinkedList(new int[]{1});
		ListNode test2 = arrayToLinkedList(new int[]{20,10});
		ListNode test3 = arrayToLinkedList(new int[]{1,2,3,4,5});
		ListNode test4 = arrayToLinkedList(new int[]{6,7,8,9,10});
		ListNode test5 = arrayToLinkedList(new int[]{-5,2,4,0,-7,-6,1,9,-10,12});

		System.out.println(compareLinkedList(Solution(test0,3), null));
		System.out.println(compareLinkedList(Solution(test1,3), arrayToLinkedList(new int[]{1})));
		System.out.println(compareLinkedList(Solution(test2,15), arrayToLinkedList(new int[]{10,20})));
		System.out.println(compareLinkedList(Solution(test3,6), arrayToLinkedList(new int[]{1,2,3,4,5})));
		System.out.println(compareLinkedList(Solution(test4,5), arrayToLinkedList(new int[]{6,7,8,9,10})));
		System.out.println(compareLinkedList(Solution(test5,0), arrayToLinkedList(new int[]{-5,-7,-6,-10,2,4,0,1,9,12})));
	
	}
		
}
public class Solution1{//create two linked lists, one is less than x, the other is larger than x
	public LinkedListNode partition(LinkedListNode node, int x){
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		//partition list
		while(node != null)
		{
			LinkedListNode next = node.next;
			node.next = null;
			if(node.data < x)
			{//linkedlist题目里面一定要判断首节点是不是为空
				if(beforeStart == null)
				{
					beforeStart = node;
					beforeEnd = beforeStart;
				}
				else
				{
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}
			else
			{
				if(afterStart == null)
				{
					afterStart = node;
					afterEnd = afterStart;
				}
				else
				{
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = node.next;
		}
		if(beforeStart == null)
				return afterStart;
			beforeEnd.next = afterStart;
			return beforeStart;
	}
}


//just new one list, and two node head and tail, 
//smaller than x is attacged to head, bigger than x is attached to tail
public class Solution2{
	public LinkedListNode partition(LinkedListNode node, int x){
		LinkedListNode head = null;
		LinkedListNode tail = null;
		while (node != null)
		{
			LinkedListNode next = node.next;
			if(node.data < x){
				node.next = head;
				head = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;//对这个linked list做截断处理···只要是声明出tail.next = null, 那么这个Linkedlist算是结束
		return head;
	}
}