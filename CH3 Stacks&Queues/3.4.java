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