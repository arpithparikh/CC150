// Write an algorithm to prim all ways of arranging eight queens on an 8x8 chess board
// so that none of them share the same row, column or diagonal.
// In this case, "diagonal" means all diagonals, not just the two that bisect the board.
//solve N Queen problem
public class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<List<String>>();
    List<String> temp = new ArrayList<String>();
    getQueens(result, temp, n, 0);
    return result;
  }
  private void getQueens(List<List<String>> result, List<String> temp, int n, int crt) {
    if(crt == n) {
      result.add(new ArrayList<String>(temp));
      return;
    }

    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < n; i++) {
      sb.append('.');
    }
    for(int i = 0; i < n; i++) {
      sb.setCharAt(i , 'Q');
      temp.add(sb.toString());
      if(isValid(temp)) {
        getQueens(result, temp, n, crt + 1);
      }
      sb.setCharAt(i , '.');
      temp.remove(temp.size() - 1);
    }
  }
  private boolean isValid(List<String> temp) {

    int row = temp.size();
    int col = temp.get(0).length();
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(temp.get(i).charAt(j) == 'Q') {
          //check current column
          for(int k = 0; k < row; k++) {
            if(temp.get(k).charAt(j) == 'Q' && k != i) {
              return false;
            }
          }
          //check current row
          for(int k = 0; k < col; k++) {
            if(temp.get(i).charAt(k) == 'Q' && k != j) {
              return false;
            }
          }
          //check diagnol
          int temp1 = i - 1;
          int temp2 = j - 1;
          while(temp1 >= 0 && temp1 < row && temp2 >= 0 && temp2 < col) {
            if(temp.get(temp1).charAt(temp2) == 'Q') {
              return false;
            }
            temp1--;
            temp2--;
          }

          temp1 = i - 1;
          temp2 = j + 1;
          while(temp1 >= 0 && temp1 < row && temp2 >= 0 && temp2 < col) {
            if(temp.get(temp1).charAt(temp2) == 'Q') {
              return false;
            }
            temp1--;
            temp2++;
          }
        }
      }
    }
    return true;
  }
}
