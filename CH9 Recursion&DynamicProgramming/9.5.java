// Write a method to compute all permutations of a string
//time O(n!)
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(nums == null || nums.size() == 0) {
          return res;
        }

        ArrayList<Integer> temp = new ArrayList<Integer>();

        helper(nums, res, temp);

        return res;
    }
    private void helper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> res,
    ArrayList<Integer> temp) {
      //因为触碰到低端就要返回，所以说直接判断temp.size()和nums.size()的关系就好了
      if(temp.size() == nums.size()) {
        res.add(new ArrayList<Integer>(temp));
        return;
      }
      for(int i = 0; i < nums.size(); i++) {
        if(temp.contains(nums.get(i))) {
          continue;
        }
        temp.add(nums.get(i));
        helper(nums, res, temp);
        temp.remove(temp.size() - 1);
      }
    }
}
