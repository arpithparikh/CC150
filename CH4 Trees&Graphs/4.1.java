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



/*
4.1
Implement a function to check if a binary tree is balanced. 
For the purposes of this question, a balanced tree is defined to be a tree such that the heights 
of the two subtrees of any node never differ by more than one.
*/

package CC150;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class Solution {
	
	public static boolean isBalanced(TreeNode root){
		if(root == null){
			return false;
		}
		int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
		if(heightDiff>1){
			return false;
		}
		else
			return isBalanced(root.left)&&isBalanced(root.right);
	}
	private static int getHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	public static TreeNode test1(){
		TreeNode node1 = new TreeNode(7);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(9);
		node1.left = node2; node1.right = node3;
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		node2.left = node4; node2.right = node5;
		TreeNode node6 = new TreeNode(8);
		TreeNode node7 = new TreeNode(10);
		node3.left = node6; node3.right = node7;
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(10);
		node4.left = node8; node4.right = node9;
		TreeNode node10 = new TreeNode(10);
		node5.right = node10;
		TreeNode node11 = new TreeNode(11);
		node7.right = node11;
		TreeNode node12 = new TreeNode(0);
		node8.left = node12;
		return node1;
	}
	public static TreeNode test2(){
		TreeNode node1 = new TreeNode(7);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(9);
		node1.left = node2; node1.right = node3;
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		node2.left = node4; node2.right = node5;
		//TreeNode node6 = new TreeNode(8);
		TreeNode node7 = new TreeNode(10);
		//node3.left = node6; 
		node3.right = node7;
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(10);
		node4.left = node8; node4.right = node9;
		TreeNode node10 = new TreeNode(10);
		node5.right = node10;
		TreeNode node11 = new TreeNode(11);
		node7.right = node11;
		TreeNode node12 = new TreeNode(0);
		node8.left = node12;
		return node1;
	}

	public static TreeNode test3(){
		TreeNode node1 = new TreeNode(7);
		TreeNode node2 = new TreeNode(4);
		node1.left = node2;
		return node1;
	}

	public static TreeNode test4(){
		TreeNode node1 = new TreeNode(7);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(9);
		node1.right = node2;
		node2.right = node3;
		return node1;
	}

	public static TreeNode test5(){
		TreeNode node1 = new TreeNode(7);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(9);
		node1.left = node2;
		node1.right = node3;
		return node1;
	}

	public static void main(String[] args) {	
		

		TreeNode root1 = test1();
		System.out.println(isBalanced(root1));

		TreeNode root2 = test2();
		System.out.println(isBalanced(root2));

		TreeNode root3 = test3();
		System.out.println(isBalanced(root3));

		TreeNode root4 = test4();
		System.out.println(isBalanced(root4));
		
		TreeNode root5 = test5();
		System.out.println(isBalanced(root5));
		
		
		
	}		
}

