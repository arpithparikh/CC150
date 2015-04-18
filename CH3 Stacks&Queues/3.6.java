//write a program to sort a stack in ascending order(biggest on the top).
// You may use at most one additional stack to hold items, 
// but you may not copy the elements into any other data structure(such as array). 
// The stack supports the following operations: push, pop, peek and isEmpty
public class Solution{
	public static Stack<Integer> sort(Stack<Integer> start){
		Stack<Integer> res = new Stack<Integer>();
		while(!start.isEmpty())
		{
			int tmp = start.pop();
			while(!res.isEmpty()&&res.peek() > tmp)
			{
				start.push(res.pop());
			}
			res.push(tmp);
		}
		return res;
	}
}