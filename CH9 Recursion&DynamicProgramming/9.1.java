// 9.1 A child is running up a staircase with n steps, and can hop either 1 steps, 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways the child can run up the stairs
//此题比较基础，注意题目中所说的可以跳1、2、3步，所以说这样子下一个状态的推导需要前三个状态一起来得出
public class Solution {
  public int jump(int n) {
    if(n < 1) {
      return 0;
    }
    int[] f = new int[n + 1];
    f[0] = 1;
    f[1] = 1;
    f[2] = 2;
    f[3] = 4;
    for(int i = 4; i <= n; i++) {
      f[n] = f[n - 1] + f[n - 2] + f[n - 3];
    }
    return f[n];
  }
}
