//write a code to partition a linked list around the value x
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