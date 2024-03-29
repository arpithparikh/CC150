//write an algorithm to find the 'next' node of a given node in a binary search tree.
//You may assume that each node has a link to its parent
public class Solution{
	public TreeNode findNext(TreeNode n){
		if(n == null)
			return null;
		if(n.right!=null)
			return leftMostChild(n.right);
		else
		{
			TreeNode q = n;
			TreeNode x = q.parent;
			while(x!=null && x.left!=q)
			{
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
	private TreeNode leftMostChild(TreeNode n)
	{
		if(n==null)
			return null;
		while(n.left!=null)
			n = n.left;
		return n;
	}
}