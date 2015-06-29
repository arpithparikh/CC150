//3.4  Towers of Hanoi
public class Solution{
	public void moveDisks(String args[]){
		if(n < 1 )
			return;
		int n =3;
		Tower[] towers = new Tower[n];
		for(int i =0;i<n;i++)
			towers[i] = new Tower(i);
		for(int i < n;i>=0;i--)
			towers[0].add(i);
		towers[0].moveDisks(n,towers[2],towers[1]);
	}
	public class Tower{
		private Stack<Integer> disks;
		private int index;
		public Tower(int i ){
			return index;
		}
		public int index(){
			return index;
		}
		public void add(int d){
			if(!disks.isEmpty()&&disks.peek() <=d)
				return;
			else
				disks.push(d);
		}
		public void moveTopTo(Tower t){
			int top = disks.pop();
			t.add(top);
		}
		public void moveDisks(int n , Tower destination, Tower buffer){
			if(n > 0){
				moveDisks(n-1, buffer, destination);
				moveTopTo(destination)；
				buffer.moveDisks(n-1, destination,this);
			}
		}
	}
}


//
package CC150;
import java.util.Stack;



public class Solution {
	

	public static void hanoi(int n, Stack<Integer> srcStack, Stack<Integer> dstStack, Stack<Integer> helperStack){
		if( n <= 0 ){
			return;
		} 
		// 第一次进入时，问题规模还是n, 还没有进行分解。三个堆栈都以参数形式传递进来了。
		hanoi( n - 1, srcStack, helperStack, dstStack);
		dstStack.add( srcStack.pop() );
		hanoi( n - 1, helperStack, dstStack, srcStack);

	}

	public static void main(String[] args) {	
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();
		stack1.push(4);stack1.push(3);stack1.push(2);stack1.push(1);
		int size = stack1.size();
		hanoi(size, stack1,stack3,stack2);
		while( !stack3.empty() ){
			System.out.println(stack3.pop());
		}
	}		
}