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





package CC150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}




public class Solution {

	public static ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
		if(root == null){
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
			int size = queue.size();
			for(int i =0;i<size;i++)
			{
				TreeNode tmp = queue.poll();
				temp.add(tmp);
				if(tmp.left!=null){
					queue.offer(tmp.left);
				}
				if(tmp.right!= null){
					queue.offer(tmp.right);
				}
			}
			res.add(temp);
		}
		return res;
	}

	public static void main(String[] args) {
		
		System.out.println("Tree #0");
		TreeNode root0 = null;   // 空树
		ArrayList<LinkedList<TreeNode>> tree0 = createLinkedList(root0);
		System.out.println( tree0.size() == 0 );

		System.out.println("");
		System.out.println("Tree #1");
		/*
					0
		*/
		TreeNode root1 = new TreeNode(0); //只有根节点0
		ArrayList<LinkedList<TreeNode>> tree1 = createLinkedList(root1);
		System.out.println( tree1.size() == 1 );		
		for(int i = 0; i < tree1.size(); i++){
			LinkedList<TreeNode> list = tree1.get(i);
			for(TreeNode temp:list){
				System.out.print(temp.val + "->");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("Tree #2");

		/*
		 *                 0
		 *                / \
		 *               1   2
		 *              /     \
		 *             3       4
		 */
		TreeNode root2 = new TreeNode(0);  
		TreeNode node21 = new TreeNode(1);TreeNode node22 = new TreeNode(2);
		TreeNode node23 = new TreeNode(3);TreeNode node24 = new TreeNode(4);
		root2.left = node21; root2.right = node22;
		node21.left = node23; node22.right = node24;

		ArrayList<LinkedList<TreeNode>> tree2 = createLinkedList(root2);
		System.out.println( tree2.size() == 3 );		
		for(int i = 0; i < tree2.size(); i++){
			LinkedList<TreeNode> list = tree2.get(i);
			for(TreeNode temp:list){
				System.out.print(temp.val + "->");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("Tree #3");
		/*
		 *                 0
		 *                / \
		 *               1   2
		 *                    \
		 *                     3
		 *                      \
		 *                       4
		 */
		TreeNode root3 = new TreeNode(0);
		TreeNode node31 = new TreeNode(1);TreeNode node32 = new TreeNode(2);
		TreeNode node33 = new TreeNode(3);TreeNode node34 = new TreeNode(4);
		root3.left = node31; root3.right = node32;
		node32.right = node33; node33.right = node34;		

		ArrayList<LinkedList<TreeNode>> tree3 = createLinkedList(root3);
		System.out.println( tree3.size() == 3 );		
		for(int i = 0; i < tree3.size(); i++){
			LinkedList<TreeNode> list = tree3.get(i);
			for(TreeNode temp:list){
				System.out.print(temp.val + "->");
			}
			System.out.println("");
		}
		System.out.println("");


		
		
	}		
}
