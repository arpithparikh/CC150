//Implement an algorithm to determine if a string has all unique characters. 
//What if you cannot use additional data structure
//first ask the string is Unicode string or ASCII string
// Unicode is a superset of ASCII, ASCII only defines 128 characters, which mappes 0-127
// but Unicode defines 2^21(maybe less than), and mappes to 0-2^21, 
// but the ASCII can be the same meaning in the Unicode
//the length of string is str.length()
//the length of array is array.length
//array[i], str.charAt(i). array=>[], string => ()
//time complexity is O(n)
package CC150;

import java.util.Arrays;

public class Solution {
	public static boolean Solution(String str){
		
		if(str == null || str.length()<0||str.length()>128)
			return false;
		boolean[] check = new boolean[256];
		for(int i =0;i<str.length();i++)
		{
			if(check[str.charAt(i)])
				return false;
			else
				check[str.charAt(i)] = true;
		}
		return true;
	}

	public static void main(String[] args) {	
		String s0 = null;
		String s1 = "";
		String s2 = "abcdefg";
		String s3 = "abcadg";
		String s4 = "z";
		String s5 = "$@)+~e";
		String s6 = "  ";
		String s7 = " ad4-+";

		System.out.println(Solution(s0)); 
		System.out.println(Solution(s1)); 
		System.out.println(Solution(s2)); 
		System.out.println(Solution(s3)); 
		System.out.println(Solution(s4)); 
		System.out.println(Solution(s5)); 
		System.out.println(Solution(s6)); 
		System.out.println(Solution(s7)); 
	}		
}

//time complexity O(nlogn), sort first and then compare adjacent element to check whether they are the same
package CC150;

import java.util.Arrays;

public class Solution {
	public static boolean Solution(String str){
		if(str == null || str.length()<0||str.length()>128)
			return false;
		char[] res = str.toCharArray();
		Arrays.sort(res);
		for(int i =0;i<res.length-1;i++)
		{
			if(res[i] == res[i+1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {	
		String s0 = null;
		String s1 = "";
		String s2 = "abcdefg";
		String s3 = "abcadg";
		String s4 = "z";
		String s5 = "$@)+~e";
		String s6 = "  ";
		String s7 = " ad4-+";

		System.out.println(Solution(s0)); 
		System.out.println(Solution(s1)); 
		System.out.println(Solution(s2)); 
		System.out.println(Solution(s3)); 
		System.out.println(Solution(s4)); 
		System.out.println(Solution(s5)); 
		System.out.println(Solution(s6)); 
		System.out.println(Solution(s7)); 
	}		
}



