//given a binary tree, design an algorithm twhich creates a linked list of all the nodes at each depth
//if you have a tree with depth D, you'll have D linked lists
public class Solution1{
	public ArrayList createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		level = 0;
		if(root == null)
			return;
		LinkedList<TreeNode> list = null;
		if(lists.size() == level)//
		{
			list= new LinkedList<TreeNode>();
			lists.add(list);
		}
		else list = lists.get(level);
		list.add(root);
		createLevelLinkedList(root.left, lists, level+1);
		createLevelLinkedList(root.right, lists, level+1);
	}
	return lists;
}
//using BFS,time O(n), space O(logn)
public class Solution2{
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root{
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
		if(root == null)
			return res;
		LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
		cur.add(root);
		while(cur.size()>0)
		{
			res.add(cur);
			LinkedList<TreeNode> parents = cur;
			cur = new LinkedList<TreeNode>();
			for(TreeNode parent:parents)
			{
				if(parent.left != null)
					cur.add(parent.left);
				if(parent.right!= null)
					cur.add(parent.right);
			}
		}
		return res;
	}
}