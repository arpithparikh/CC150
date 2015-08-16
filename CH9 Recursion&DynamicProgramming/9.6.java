// Implement an algorithm to print all valid
// (i.e., properly opened and closed) combinations of n-pairs of parentheses.
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();

        if(n < 1) {
            return res;
        }
        String temp = new String();
        helper(res, temp, n, n);
        return res;
    }
    private void helper(List<String> res, String temp, int left, int right) {
        if(left > right) {
            return;
        }
        if(left == 0 && right == 0) {
            res.add(new String(temp));
        }
        if(left > 0) {
            helper(res, temp + "(", left - 1, right);
        }
        if(right > 0) {
            helper(res, temp + ")", left, right - 1);
        }
    }
}
