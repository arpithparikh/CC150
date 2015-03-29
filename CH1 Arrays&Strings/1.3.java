//Given two strings, write a method to decide if one is a permutation of the other
//Note that we will first make a assumption that the comparison is a case sensitive and whitespace is significant. 
// "god     " is different from "dog"
//Solution1, first sort the string, because the string 1 and string 2 are ust characters in different order
//So sort the string first will put the characters from two permutations in the same order
// we just need to compare the sorted verison of two strings
public class Solution1{
	public boolean isPermutation(String str1, String str2){
		if(str1==null||str2==null||str1.length() ==0||str2.length()==0||str1.length()!= str2.length())
			return false;
		String s1 = new String(str1.length());
		String s2 = new String(str2.length());
		s1 = Sort.str1;
		s2 = Sort.str2;
		for(int i =0;i<str1.length();i++)
		{
			if(s1.charAt(i) == s2.charAt(i))
				return true;
		}
			
		return false;
	}
		
}

//we assume that the character set is ASCII
public class Solution2{
	public boolean isPermutation(String str1. String str2){
		if(str1.length() != str2.length())
			return false;
		int[] letters = new int[256];//ASCII码有256个状态
		char[] s_array = s.toCharArray();//Converts this string to a new character array.
		for(char c : s_array)//cpunt number of each char in s
		letters[c]++;
		for(int i =0;i<str2.length();i++){
			int c = (int) t.charAt(i);
			if(--letters[c]<0)
				return false;
		}
		return true;
	}
}