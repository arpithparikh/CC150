// Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes, 
// write a method to rotate the image by 90 degrees.
// Can you do this in place ?
package CC150;


public class Solution {
	
	public static void rotateLeft(int[][] data){
		if( data == null || data.length == 0 || data[0].length == 0 ){
			return;
		}

	}
	
	public static void rotateMatrix(int[][] matrix){
		if(matrix == null||matrix.length == 0|| matrix[0].length==0)
			return;
		int level = matrix.length/2;
		for(int i =0;i<level;i++){
			for(int j =level;j<matrix.length-1-level;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length-1-j][i];
				matrix[matrix.length-1-j][i]=matrix[matrix.length-1-i][matrix.length-1-j];
				matrix[matrix.length-1-i][matrix.length-1-j]=matrix[j][matrix.length-1-i];
				matrix[j][matrix.length-1-i] = temp;
			}
		}
	}

	public static void main(String[] args) {	

		int[][] matrix = new int[][] { { 3, 1, 6, 23, 77 }, { 54, 7, 1, 56, 8 },
				{ 6, 22, 55, 1, 7 }, { 0, 7, 58, 7, 54 }, { 9, 7, 8, 5, 22 } };
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("," + matrix[i][j]);
			}
			System.out.println();
		}
		rotateMatrix(matrix);	
		System.out.println("======================");	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("," + matrix[i][j]);
			}
			System.out.println();
		}

	}		
}