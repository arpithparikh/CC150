//describe how you would use a single array to implement three stacks
//for stack1, we use [0, n/3)
//for stack2, we use [n/3, 2n/3)
//for stack3, we use [2n/3, n)
//solution1, fixed size division
public class Solution1{
	int stackSize = 100;
	int[] buffer = new int[stackSize*3];
	int[] stackPointer = {-1, -1, -1};//pointer to track the top element
	
}