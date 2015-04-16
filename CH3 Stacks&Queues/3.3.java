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
