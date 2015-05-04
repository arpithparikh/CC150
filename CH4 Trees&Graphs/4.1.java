//check if a binary tree is balanced
//find height of tree from recursive function,but for each node, time complexity is O(nlogn)
//total time complexity is O(2nlogn) = O(nlogn)
public class Solution1{
	public boolean isBalanced(TreeNode root){
		if(root == null)
			return false;
		int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
		if(heightDiff > 1)
			return false;
		else return isBalanced(root.left) && isBalanced(root.right);
	}
	private int getHeight(TreeNode root){
	if(root == null)
		return 0;
	else return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
}
//O(n)time and O(n)space
public class Solution2{
	public boolean isBalanced(TreeNode root){
		if(checkHeight(root) == -1)
			return false;
		else
			return true;
	}
	private int checkHeight(TreeNode root){
		if(root == null)
			return 0;
		int leftHeight = checkHeight(root.left);
		int rightHeight = checkHeight(root.right);
		if(leftHeight == -1)
			return -1;
		if(rightHeight == -1)
			return -1;//not balanced
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1)
			return -1;
		else return Math.max(leftHeight, rightHeight)+1;
	}
}