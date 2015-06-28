public class Solution{
	ArrayList<Stack> res = new ArrayList<Stack>();
	public void push(int value){
		Stack last = getLastStack();
		if(last != null && !last.isFull())
			last.push(value);
		else
		{
			Stack newStack = new Stack(capacity);
			newStack.push(value);
			res.add(newStack);
		}
	}
	public int pop(){
		Stack last = getLastStack();
		int value = last.pop();
		if(last.size == 0)
			res.remove(res.size()-1);
		return value;
	}
	public Stack getLastStack(res){
		if(res.size() == 0)
			return null;
		else
		return res.(res.size()-1);
	}
}
/*
3.3
Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. 
Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and 
should create a new stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave 
identically to a single stack (that is,pop() should return the same values as it would if there were just a single stack).

FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
*/
package CC150;
import java.util.Stack;

class SetOfStacks{

	public SetOfStacks(int val){

	}

	public void push(int val){

	}

	public int pop(){

		return -1;
	}

}

public class Solution {
	
	public static void main(String[] args) {	
		SetOfStacks stackSets = new SetOfStacks(3);
		stackSets.push(1);stackSets.push(2);stackSets.push(3);
		System.out.println(3==stackSets.pop()); System.out.println(2==stackSets.pop());
		stackSets.push(4);stackSets.push(5);stackSets.push(6);System.out.println(6==stackSets.pop());
		stackSets.push(7);stackSets.push(8);stackSets.push(9);
		System.out.println(9==stackSets.pop());
		System.out.println(8==stackSets.pop());
		System.out.println(7==stackSets.pop());
		stackSets.push(-1);stackSets.push(-2);stackSets.push(-3);
		stackSets.push(-4);System.out.println(-4==stackSets.pop());
		System.out.println(-3==stackSets.pop());
		System.out.println(-2==stackSets.pop());
		System.out.println(-1==stackSets.pop());
		System.out.println(5==stackSets.pop());
		System.out.println(4==stackSets.pop());
		System.out.println(1==stackSets.pop());
		System.out.println(-1==stackSets.pop());
	}		
}
