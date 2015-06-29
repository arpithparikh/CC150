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

// 1.you may use at most one additional stack to hold item
// 2. but not copy element into any data structure(such as an array)
// 3.stack support push, pop, peek, isEmpty
package CC150;
import java.util.Stack;


public class Solution {
	public static void sortStack(Stack<Integer> stack){
		Stack<Integer> buffer = new Stack<Integer>();
		Stack<Integer> buffer1 = new Stack<Integer>();
		while(!stack.isEmpty()){
			int temp = stack.pop();
			while(!buffer.isEmpty()&&buffer.peek() > temp){
				stack.push(buffer.pop());
			}
			buffer.push(temp);
		}
		while( !buffer.empty() ){
			buffer1.push( buffer.pop() );
		}
		while( !buffer1.empty() ){
			stack.push( buffer1.pop() );
		}
	}

	public static void main(String[] args) {	
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push(5);stack1.push(4);stack1.push(3);stack1.push(2);stack1.push(1);
		System.out.println("test case 1:");
		while( !stack1.empty() ){
			System.out.print(stack1.pop() + ", ");
		}
		stack1.push(5);stack1.push(4);stack1.push(3);stack1.push(2);stack1.push(1);
		sortStack(stack1);
		System.out.println("\nResult:");
		while( !stack1.empty() ){
			System.out.print(stack1.pop() + ", ");
		}	
		System.out.println("\ntest case 2:");
		Stack<Integer> stack2 = new Stack<Integer>();
		stack2.push(5);stack2.push(2);stack2.push(7);stack2.push(1);stack2.push(6);	
		while( !stack2.empty() ){
			System.out.print(stack2.pop() + ", ");
		}
		System.out.println("\nResult:");
		stack2.push(5);stack2.push(2);stack2.push(7);stack2.push(1);stack2.push(6);	
		sortStack(stack2);
		while( !stack2.empty() ){
			System.out.print(stack2.pop() + ", ");
		}
	}		
}