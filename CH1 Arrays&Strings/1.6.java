// Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes, 
// write a method to rotate the image by 90 degrees.
// Can you do this in place ?
pubcli class Solution{
	public void rotateMatrix(int[][] matrix){
		if(matrix == null || matrix.length == 0|| matrix[0].length == 0)
			return;
		int length = matrix.length;
		int level = matrix.length/2;
		for(int i =0;i< level;i++){
			for(int j =0;j<matrix.length-1-i;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[length-1-j][i];
				matrix[length-1-j][i] = matrix[length-1-i][length-1-j];
				matrix[length-1-i][length-1-j] = matrix[j][length-1-i];
				matrix[j][length-1-i] = temp;
			}
		}
		return;
	}
}