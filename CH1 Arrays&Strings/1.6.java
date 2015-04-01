public class Solution{
	public void rotateMatrix(int[][] matrix){
		if(matrix == null || matrix.length == 0|| matrix[0].length ==0)
			return;
		int row = matrix.length;
		for(int i =0; i < row/2; i++)
		{
			for(int j =0;j< n-1-i;j++)
			{
				matrix temp = matrix[i][j];
				matrix[i][j] = matrix[row - j - 1][i];
				matrix[row - j - 1][i] = matrix[row - i -1][row-j-1];
				matrix[row-i-1][row-j-1] = matrix[j][row-i-1];
				matrix[j][row-i-1] = temp;
			}
		}
	}

}