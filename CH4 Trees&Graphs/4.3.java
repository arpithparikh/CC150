//given a sorted array without duplicates, implement a binary search tree with minimal height
package CC150;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


public class Solution {

	public static TreeNode createBST(int[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		int length = arr.length;
		int start = 0;
		int end = length - 1;
		TreeNode newRoot = formBST(arr, start, end);
		return newRoot;
	}
	private static TreeNode formBST(int[] arr, int start, int end){
		if(start > end){
			return null;
		}
		int mid = start + (end - start)/2 ;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = formBST(arr, start, mid -1);
		root.right = formBST(arr, mid + 1, end);
		return root;
		}
	}
	public static int getMaxHeight(TreeNode root){
		if( root == null ){
			return 0;
		}
		int left = getMaxHeight(root.left);
		int right = getMaxHeight(root.right);
		return Math.max(left,right) + 1;
	}

	

	public static void main(String[] args) {
		int[] arr0 = new int[]{};  // min height = 0
		int[] arr1 = new int[]{1}; // min height = 1
		int[] arr2 = new int[]{1,2}; // min height = 2
		int[] arr3 = new int[]{1,2,3}; // min height = 2
		int[] arr4 = new int[]{2,3,4,5,6,7,8,9};// min height = 4
		int[] arr5 = new int[]{2,3,4,5,6,7,8}; // min height = 3

		TreeNode root0 = createBST(arr0);
		TreeNode root1 = createBST(arr1);
		TreeNode root2 = createBST(arr2);
		TreeNode root3 = createBST(arr3);
		TreeNode root4 = createBST(arr4);
		TreeNode root5 = createBST(arr5);
		System.out.println( getMaxHeight(root0) == 0 );
		System.out.println( getMaxHeight(root1) == 1 );
		System.out.println( getMaxHeight(root2) == 2 );
		System.out.println( getMaxHeight(root3) == 2 );
		System.out.println( getMaxHeight(root4) == 4 );
		System.out.println( getMaxHeight(root5) == 3 );
		
	}		
}
