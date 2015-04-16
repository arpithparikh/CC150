//using additional stack to keep track of every minimum value
public class Solution{
	Stack<Integer> s2 = new Stack<Integer>();
	public void push(int value){
		if (value <= min())
			s2.push(value);
		s1.push(value);
	}
	public int pop(){
		int value = s1.pop();
		if(value == min())
			s2.pop();
		return value;
	}
	public int min(){
		if(s2.isEmpty())
			return -1;
		else 
			return s2.pop();
	}
}