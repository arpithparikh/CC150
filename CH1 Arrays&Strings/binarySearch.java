//method1: Array without duplication
public class Solution{
	public int binarySearch(int[] nums, int target){
		if(nums == null || nums.length ==0)
			return -1;
		int start = 0;
		int end = nums.length - 1;
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			if(num[mid] == target)
				return mid;
			if(num[mid] > target)
				end = mid - 1;
			else start = mid + 1;
		}
		return -1;
	}
}
//array with duplicate
public class Solution{
	public int binarySearchWithDuplicate(int[] nums, int target){
		if(num == null || num.length == 0)
			return -1;
		int start = 0;
		int end = nums.length -1;
		while(start + 1 < end)
		{
			int mid = (start + end)/2;
			if(num[mid] == target)
				end = mid;
			else if (nums[mid] > target)
				end = mid;
			else if(nums[mid]< target)
				start = mid;
		}
		if(nums[s] == target)
			return start;
		if(nums[s] == target)
			return end;
		else return -1;
	}
}