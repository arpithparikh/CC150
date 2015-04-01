public class Solution{
	public void setZeroes(int[][] matrix){
		if(matrix == null || matrix.length ==0||matrix[0].length == 0)
			return;
		boolean rowHasZero = false;
		boolean colHasZero = false;
		//如果行列里面有0的话，记录一个为0就好，反正都是要变为0的，就先跳出，待程序最后再进行置0的操作，因为第一行和第一列是要被用来作为
		//判断行和判断列的
		for(int i = 0; i< matrix.length; i++)
		{
			if(matrix[i][0] == 0)
			{
				colHasZero = true;
				break;
			}
		}
		for(int j = 0;j<matrix[0].length;j++)
		{
			if(matrix[0][j] == 0)
			{
				rowHasZero = true;
				break;
			}
		}
		//因为将第一行和第一列作为判断行列了，原来矩阵减少了，所以i和j要从1来开始递增判断
		for(int i =1;i<matrix.length;i++){
			for(int j = 1;j< matrix[0].length;j++){
				if(matrix[i][j] == 0)
					{
						matrix[i][0] =0;
						matrix[0][j] =0;
					}
			}
		}
		//对上一个判断的执行，如果行列存在有0，那么就将这一行与这一列全部置为0
		for(int i = 1;i<matrix.length;i++){
			for(int j=1;j<matrix[0].length;j++){
				if(matrix[i][0] == 0||matrix[0][j] ==0)
					matrix[i][j] =0;
			}
		}
		//如果在题目之前开始判断的这一列存在有0的话，那么col为true，那么就可以将这一列所有全部置为0
		if(colHasZero)
		{
			for(int i =0;i<matrix.length;i++)
				matrix[i][0] =0;
		}
		//如果在题目之前开始判断的这一行存在有一个0的话，那么就不需要继续判断了，反正都是要变成0的。如果为true的话，那么就将
		//这一行的所有元素也都变成0
		if(rowHasZero)
		{
			for(int i =0;i<matrix[0].length;i++)
				matrix[0][i] = 0;
		}
	}
}