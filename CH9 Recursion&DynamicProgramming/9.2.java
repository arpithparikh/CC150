// Imagine a robot sitting on the upper left corner of an X by Y grid.
// The robot can only move in two directions: right and down.
// How many possible paths are there for the robot to go from (0, 0) to (X, Y)?
public class Solution {
  public int uniquePath(int m, int n) {
    if(m < 1 || n < 1) {
      return 0;
    }
    int[][] f = new int[m][n];
    for(int i = 0; i < m; i++) {
      f[i][0] = 1;
    }
    for(int i = 0; i < n; i++) {
      f[0][i] = 1;
    }
    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        f[i][j] = f[i - 1][j] + f[i][j - 1];
      }
    }
    return f[m - 1][n - 1];
  }
}
// FOLLOW UP
// Imagine certain spots are "off limits",
// such that the robot cannot step on them.
// Design an algorithm to find a path for the robot from the top left to the bottom right
public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
        	return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        if(obstacleGrid[0][0] == 0) {
        	res[0][0] = 1;
        }
        else {
        	res[0][0] = 0;
        }
        for(int i = 1; i < m; i++) {
        	if(obstacleGrid[i][0] == 1 || res[i - 1][0] == 0) {
        		res[i][0] = 0;
        	}
        	else {
        		res[i][0] = 1;
        	}
        }
        for(int i = 1; i < n; i++) {
        	if(obstacleGrid[0][i] == 1 || res[0][i - 1] == 0) {
        		res[0][i] = 0;
        	}
        	else {
        		res[0][i] = 1;
        	}
        }
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			res[i][j] = 0;
        		}
        		else {
        			res[i][j] = res[i - 1][j] + res[i][j - 1];
        		}
        	}
        }
        return res[m - 1][n - 1];
    }
}
