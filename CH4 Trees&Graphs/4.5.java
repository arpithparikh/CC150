//valid binary search tree, node.left.val<= node.val && node.val < node.right.val, 
//but may cause bug, so we choose passing down min and max values
//is recursive happen, the space complexity is the same as the time complecity which is the O(logn)
public class Solution{
	public boolean isBinarySearchTree(TreeNode root, Integer min, Integer max){
		if(root == null)
			return true;
		min = Integer.MIN_VALUE;
		max = Integer.MAX_VALUE;
		if((min!=null&&root.data<=min)||(max!=null&&root.data>max))
			return false;
		if(!isBinarySearchTree(root.left, min,root.data)||!isBinarySearchTree(root.right, root.data, max))
			return false;
		return true;
	}
}


//do the in order travsersal and to check whether the element in array is sorted
//this could only be done for the case that tree do not have duplicates bacause left and node can have the same value
