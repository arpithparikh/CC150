//Create an algorithm to decide if T2 is a subtree of T1
//Solution1, we need to compare inorder and pre order of two tree, but we should insert a 0 as null position
//iterative tree1 and to find the occur time of root of t2, if occur, iterative tree2 to compare whether two tree are identical
public class Solution2{
	public boolean isSubtree(TreeNode t1, TreeNode t2){
		if(t1 == null)
			return false;
		if(t2 == null)
			return true;
		return subTree(t1, t2);
	}
	//find root match
	private boolean subTree(TreeNode t1, TreeNode t2){
		if(t1 == null)
			return false;
		if(t2 == null)
			return true;
		if(t1.data == t2.data)
		{
			if(matchTree(t1,t2))
				return true;
		}
		return subTree(t1.left, t2) || subtree(t1.right,t2);
	}
	//after find root match, find the subtree match
	private matchTree(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null)
			return true;
		if(t1 == null || t2 == null)
			return false;
		if(t1.data != t2.data)
			return false;
		return matchTree(t1.left,t2.left)&&matchTree(t1.right,t2.right);
	}
}
//solution1 take O(m+n) memory while solution2 takes o(logm+logn) memory
//solution1 take O(n+m) while solution2 takes O(mn) as worst case, and tight bound is O(m+nk),n is the occur time t2 root occurs
//Overall, solution2 is better 