//do a BFS to check whether each level
//space complexity is O(logn), time complexity O(nlogn), n nodes and each node do a recursive, which is logn
public class Solution{
	public void findSum(TreeNode node, int sum, int[] path, int level){
		if(root == null)
			return;
		path[level] = node.data;
		int t = 0;
		for(int i = level;i>=0;i--)
		{
			t += path[i];
			if(i == sum)
				print(path, i, level);
		}
		findSum(node.left, sum, path, level+1);
		findSum(node.right, sum, path, level+1);
		path[level] = Integer.MIN_VALUE;
	}
	private void findSum(TreeNode node, int sum){
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path,0);
	}
	private void print(int[] path, int start, int end){
		for(int i =start; i<=end;i++)
			System.out.print(path[i] + " ");
		System.out.println();
	}
	private int depth(TreeNode node){
		if(node == null)
			return 0;
		return 1+Math.max(depth(node.left), depth(node.right));
	}
}