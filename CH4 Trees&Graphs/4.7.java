//Design an algorithm to find the first common ancestor of two nodes in a binary tree
//time complexity O(n)
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