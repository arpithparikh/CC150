//implement a MyQueue class which implements a queue using two stacks
package CC150;
import java.util.Stack;

class MyQueue{
	Stack<Integer> stack1, stack2;
	public MyQueue(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	public void push(int x){
		stack1.push(x);
	}
	public int pop(){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	public int peek(){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.peek();
		//return -1;
	}
}

public class Solution {
	
	public static void main(String[] args) {	
		MyQueue test = new MyQueue();
		test.push(1);
		System.out.println(test.pop());
		test.push(2);
		test.push(3);
		System.out.println(test.peek());
		System.out.println(test.pop());
	}		
}