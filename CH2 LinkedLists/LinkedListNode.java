public class LinkedListNode{
	int data;
	LinkedListNode next;
	public LinkedListNode(int x){
		data = x;
		next = null;
	}
	public static LinkedListNode buildList(int[] A){
		LinkedListNode head = new LinkedListNode(A[0]);
		for(i = 1;i < A.length;i++)
		{
			head.next = new LinkedListNode(A[i]);
			head = head.next;
		}
		return head;
	}
	public static void printList(LinkedListNode n){
		if(n == null)
			System.out.println("NULL");
		else
		{
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println();
	}
}