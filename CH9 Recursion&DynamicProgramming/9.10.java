// You have a stack of n boxes, with widths w., heights l\ and depths d r
// The boxes cannot be rotated and can only be stacked on top of one another
// if each box in the stack is strictly larger than the box above it in width, height, and depth.
// Implement a method to build the tallest stack possible,
// where the height of a stack is the sum of the heights of each box.
//按照题意说的，1.我们需要来堆盒子使得我上面一个盒子的长宽高要严格的小于下面一个盒子的长宽高
//2.求出能够堆盒子的最大高度
//3.能够放在上面的盒子需要满足的条件是
//(preLength > curLength) && (preWidth > curWidth) && (preHeight > curHeight)
public class Solution {
  public int maxHeight(int[] box){
    if(box == null || box.length == 0) {
      return 0;
    }
    boolean[] isUsed = new boolean[box.length()];
    int preWidth = Integer.MAX_VALUE;
    int preDepth = Integer.MAX_VALUE;
    return helper(box, isUsed, preWidth, preDepth);
  }
  private int helper(int[] box, boolean[] isUsed, int preWidth, preDepth) {
    int maxHeight = 0;
    for(int i = 0; i < box.length; ++i) {
      Box tempBox = box[i];
      if(!isUsed[i]) {
        isUsed[i] = true;
        if(preWidth >= box.width && preDepth >= box.depth) {
          int height = helper(box, isUsed, box.width, box.depth);
          maxHeight = Math.max(maxHeight, height + box.height);
        }
      }
      isUsed[i] = false;
    }
    return maxHeight;
  }
}
