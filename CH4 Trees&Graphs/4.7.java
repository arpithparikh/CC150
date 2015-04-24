//Design an algorithm to find the first common ancestor of two nodes in a binary tree
//time complexity O(n), but the covers function cost too much because it will go through all the node in the tree
public class Solution1{
	private boolean covers(TreeNode root, TreeNode n){
		if(root == null)
			return false;
		if(root == n)
			return true;
		return covers(root.left,n) || covers(root.right,n)
	}
	private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
		if(root == null)
			return false;
		if(p==root||q==root)
			return root;
		boolean pOnLeft = covers(root.left, p);
		boolean qOnLeft = covers(root.left,q);
		if(pOnLeft&&!qOnLeft)
			return root;
		TreeNode child = pOnLeft? root.left:root.right;//不停地迭代下去，总会分出来一个root使得p和q在它的两边，这样子就直接返回root就好了
		//注意看返回值很总要，是解题的思路
		return helper(child, p,q);
	}
	public TreeNode commonAncestors(TreeNode root, TreeNode p, TreeNode q){
		if(!covers(root,p)||!covers(root,q)||root == null)
			return null;
		return helper(root,p,q);
	}
}

//write by myself
public class Solution{
	public TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(!covers(root,p)||!covers(root,q)||root == null)
			return null;
		return helper(root,p,q);
	}
	private  boolean covers(TreeNode root, TreeNode n){
		if(root == null)
			return false;
		if(n == root)
			return true;
		return covers(root.left, n) || covers(root.right,n);
	}
	private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
		if(root == null||!covers(root,p)||!covers(root,q))
			return false;
		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnright = covers(root.right,p);
		if(pIsOnLeft&&qIsOnright)
			return root;
		else
		{
			TreeNode newRoot = pIsOnLeft? root.left:root.right;
			helper(newRoot, p,q);
		}
	}
}

public class Solution3{
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		Result r = helper(root, p, q);
		if(r.isAncestor)
			return r.node;
		return null;
	}
	public static class Result{
		public TreeNode node;
		public boolean isAncestor;
		public Result(TreeNode n, boolean isAnc){
			node = n;
			isAncestor = inAnc;
		}
	}
	Result helper(TreeNode root, TreeNode p, TreeNode q){
		if(root == null)
			return new Result(null, false);
		if(root == p&& root ==q)
			return new Result(root, true);
		Result rx = helper(root.left, p,q);
		if(rx.isAncestor)
			return rx;
		Result ry = helper(root.right,p,q);
		if(ry.isAncestor)
			return ry;
		if(rx.node!= null && ry.node != null)
			return new Result(root,true);
		else if(root ==p || root == q)
		{
			boolean isAncestor = rx.node != null || ry.node != null? true:false;
			return new Result(root, isAncestor);
		}
		else 
			return new Result(rx.node != null? rx.node:ry.node,false);
	}
}

