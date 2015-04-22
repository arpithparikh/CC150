//given a sorted array without duplicates, implement a binary search tree with minimal height
public class Solution{
	public TreeNode creatMinimalBST(int arr[], int start, int end){
		start = 0;
		end = arr.length-1;
		if(end < start)
			return;
		while(start +1 < end)
		{
			int mid = start + (end-start)/2;
			TreeNode n = new TreeNode(arr[mid]);
			n.left = creatMinimalBST(arr, start, mid-1);
			n.right = creatMinimalBST(arr, mid+1,end);
		}
		return n;//n现在是root节点了，所以说直接返回n
	}
}
