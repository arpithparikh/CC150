//Implement a function to reverse a string
// time complexity O(n), space complexity O(n)
package CC150;

public class Solution {
	public static String Solution(String s){
		StringBuffer res = new StringBuffer();
		if(s == null || s.length() == 0)
			return res.toString();
		for(int i =0;i<s.length();i++)
		{
			res.append(s.charAt(s.length()-i-1));
		}
		return res.toString();
	}

	public static void main(String[] args) {	
		String s0 = null;
		String s1 = "";
		String s2 = "iBoaiDihSniXgnahZ";
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

//time complexity O(n), space O(1)
public Solution{
	public String reverseString(String str){
		if(str == null || str.length() == 0)
			return str;
		for(int i =0; i<str.length()/2; i++)
		{
			temp = str.charAt(i);
			str.charAt(i) = str.charAt(str.length()-i);
			str.charAt(str.length()-i) = temp;
		}
		return str;
	}
}