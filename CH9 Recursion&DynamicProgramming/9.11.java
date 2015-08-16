// Given a boolean expression consisting of the symbols 0, 1, &, |, and ^, and a
// desired boolean result value, implement a function to count the number of ways parenthesizing the expression such that it evaluates to result
// EXAMPLE
// Expression: 1^0|0|1
// Desired result: false(0);
// Output: 2 ways:  1^((0|0) |1) and 1^(0|(0|1)).
// 0|0 = 0, ^是异或符号， 1^0 = 1, x ^ x= 0;
//recursion, 但是多了很多重复运算，这样子在运行时间上并不是很理想，因此可以想到用DP来解决问题
public class Solution {
  public int f(String exp, boolean result, int s, int e) {
    if(s == e) {
      if(exp.charAt(s) == '1' && result == true) {
        return 1;
      }
      else if (xp.charAt(s) == '0' && result == false) {
        return 1;
      }
      return 0;
    }
    int c = 0;
    if(result == true) {
      for(int i = s + 1; i <= e; i += 2) {
        char op = exp.charAt(i);
        if(op == '&') {
          c += f(exp, true, s, i - 1) * (exp, true, i + 1, e);
        }
        else if (op == '|') {
          c += f(exp, true, s, i - 1) * f(exp, false, i + 1, e);
          c += f(exp, false, s, i - 1) * f(exp, true, i + 1, e);
          c += f(exp, true, s, i - 1) * f(exp, true, i + 1, e);
        }
        else if (op == '^') {
          c += f(exp, true, s, i - 1) * f(exp, false, i + 1, e);
          c += f(exp, false, s, i - 1) * f(exp, true, i + 1, e);
        }
      }
      else {
        for(int i = s + 1; i <= e; i += 2) {
          char op = exp.charAt(i);
          if(op == '&') {
            c += f(exp, false, s, i - 1) * f(exp, true, i + 1, e);
            c += f(exp, true, s, i - 1) * f(exp, false, i + 1, e);
            c += f(exp, false, s, i - 1) * f(exp, false, i + 1, e);
          }
          else if (op == '|') {
            c += f(exp, false, s, i - 1) * f(exp, false, i + 1, e);
          }
          else if(op == '^') {
            c += f(exp, true, s, i - 1) * f(exp, true, i + 1, e);
            c += f(exp, false, s, i - 1) * f(exp, false, i + 1, e);
          }
        }
      }
    }
    return c;
  }
}


//DP,可以利用记忆化来减少程序运行的时间，与此同时开辟一个HashMap来记录下当前string所用的integer数目
public class Solution {
  public int f(String exp, boolean result, int s, int e, HashMap<String, Integer> q) {
    String key = "" + result + s + e;
    if(q.containsKey(key)) {
      return q.get(key);
    }

    if(s == e) {
      if(exp.charAt(s) == '1' && result == true) {
        return 1;
      }
      else if (exp.charAt(s) == '0' && result == false) {
        return 1;
      }
      return 0;
    }
    int c = 0;
    if(result == true) {
      for(int i = s + 1; i <= e; i += 2) {
        char op = exp.charAt(i) {
          if(op == '&') {
            c += f(exp, true, s, i - 1, q) * f(exp, true, i + 1, e, q);
          }
          else if(op == '|') {
            c += f(exp, true, s, i - 1, q) * f(exp, false, i + 1, e, q);
            c += f(exp, false, s, i - 1, q) * f(exp, true, i + 1, e, q);
            c += f(exp, true, s, i - 1, q) * f(exp, true, i + 1, e, q);
          }
          else if(op == '^') {
            c += f(exp, true, s, i - 1, q) * f(exp, false, i + 1, e, q);
            c += f(exp, false, s, i - 1, q) * f(exp, true, i + 1, e, q);
          }
        }
      }
      else {
        for(int i = s + 1; i <= e; i += 2) {
          char op = exp.charAt(i);
          if(op == '&') {
            c += f(exp, false, s, i - 1, q) * f(exp, true, i + 1, e, q);
            c += f(exp, true, s, i - 1, q) * f(exp, false, i + 1, e, q);
            c += f(exp, false, s, i - 1, q) * f(exp, false, i + 1, e, q);
          }
           else if (op == '|') {
             c += f(exp, false, s, i - 1, q) * f(exp, false, i + 1, e, q);
           }
           else if(op == '^') {
             c += f(exp, true, s, i - 1, q) * f(exp, true, i + 1, e, q);
             c += f(exp, false, s, i - 1, q) * f(exp, false, i + 1, e, q);
           }
        }
      }
      q.put(key, c);
      return c;
    }
  }
}

//利用卡特兰数，
//https://en.wikipedia.org/wiki/Catalan_number
//利用卡特兰数来生成总数，这样子只需要计算出true或者false的数目，对应剩下的直接用卡特兰数减去即可得到
public class Solution {
  public int f(String exp, boolean result, int s, int e, HashMap<String, Integer> q) {
    String key = "" + s + e;
    int c = 0;
    if(!q.containsKey(key)) {
      if(s == e) {
        if(emp.charAt(s) == '1') {
          c = 1;
        }
        else {
          c = 0;
        }
      }
      for(int i = s + 1; i <= e; i += 2) {
        char op = exp.charAt(i);
        if(op == '&') {
          c += f(exp, true, s, i - 1, q) * f(exp, true, i + 1, e, q);
        }
        else if(op == '|') {
          int left_ops = (i - 1 - s) / 2; // parens on left
          int right_ops = (e - i - 1) / 2; // parens on right
          int total_ways = total(left_ops) * total(right_ops);
          int total_false = f(exp,false, s, i - 1, q) * f(exp, false, i + 1,e, q);
          c += total_ways - total_false;
        }
        else if(op == '^') {
          c += f(exp, true, s, i - 1, q) * f(exp, false, i + 1, e, q);
          c += f(exp, false, s, i -1,q) * f(exp, true, i + 1, e, q);
        }
      }
      q.put(key, c);
    }
    else {
      c = q.get(key);
    }
    if(result == true) {
      return c;
    }
    else {
      int num_ops = (e - s) / 2;
      return total(num_ops) - c;
    }
  }
}
