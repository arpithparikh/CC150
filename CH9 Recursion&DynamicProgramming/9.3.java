// A magic index in an array A[0,1...n-1] is defined to be an index such that
// A[i] = i. Given a sorted array of distinct integers,
// write a method to find a magic index, if one exists, in an array
//brute force, time complexity On, space complexity O1
public class Solution {
  public int findMagicIndex(int[] nums) {
    if(nums == null || nums.length == 0) {
      return -1;
    }
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] == i) {
        return i;
      }
    }
    return -1;
  }
}
//因为这个数组是sorted，所以我们可以考虑用binary search，利用A[mid]与mid的大小关系来判断
pubilc class Solution {
  public int findMagicIndex(int[] nums) {
    if(nums == null || nums.length == 0) {
      return -1;
    }
    return helper(nums, 0, nums.length - 1);
  }
  private int helper(int[] nums, int start, int end) {
    if(end < start || start < 0 || end >= nums.length) {
      return -1;
    }
    int mid = start + (end - start) / 2;
    if(A[mid] == mid) {
      return mid;
    }
    else if(A[mid] > mid) {
      return helper(nums, start, mid - 1);
    }
    else {
      return helper(nums, mid + 1, end);
    }
  }
}
// FOLLOW UP
// What if the values are not distinct?
public class Solution {
  public int findMagicIndex(int[] nums) {
    if(nums == null || nums.length == 0) {
      return -1;
    }
    return helper(nums, 0, nums.length - 1);
  }
  private int helper(int[] nums, int start, int end) {
    if(end < start || start < 0 || end >= nums.length) {
      return -1;
    }
    int mid = start + (end - start) / 2;
    if(A[mid] == mid) {
      return mid;
    }
    int leftIndex = Math.min(mid - 1, A[mid]);
    int left = helper(nums, start, leftIndex);
    if(left >= 0) {
      return left;
    }

    int rightIndex = Math.max(A[mid], mid + 1);
    int right = helper(nums, rightIndex, end);
    if(right < nums.length) {
      return right;
    }
  }
}
