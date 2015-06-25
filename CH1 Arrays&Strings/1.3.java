//Given two strings, write a method to decide if one is a permutation of the other
//Note that we will first make a assumption that the comparison is a case sensitive and whitespace is significant. 
// "god     " is different from "dog"
//Solution1, first sort the string, because the string 1 and string 2 are ust characters in different order
//So sort the string first will put the characters from two permutations in the same order
// we just need to compare the sorted verison of two strings

//we assume that the character set is ASCII
package CC150;

import java.util.HashMap;

public class Solution {
	public static void main(String[] args) {
		// string no same size
		String str1 = "abcdfs";
		String str2 = "cba";
		System.out.println(isPermutation(str1, str2));
		// String same size but not permutaion
		str1 = "fasfasfsahf;uip";
		str2 = "fasfasfsahfauip";
		System.out.println(isPermutation(str1, str2));
		// two null String
		str1 = null;
		str2 = null;
		System.out.println(isPermutation(str1, str2));
		// two empty String
		str1 = "";
		str2 = "";
		System.out.println(isPermutation(str1, str2));
		// two permutaion String
		str1 = "asdfghjkl;l";
		str2 = "asdfghjkl;l";
		System.out.println(isPermutation(str1, str2));
 
	}
 
	private static boolean isPermutation(String str1, String str2) {
		if(str1 == null || str2 == null)
			return false;
		char[] str11 = str1.toCharArray();
		char[] str22 = str2.toCharArray();
		if(str11.length != str22.length)
			return false;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i =0;i<str11.length;i++){
			if(map.containsKey(str11[i])){
				map.put(str11[i],map.get(str11[i])+1);
			}
			else
				map.put(str11[i],1);
		}
		for(int i =0;i<str22.length;i++){
			if(map.containsKey(str22[i]))
			{
				map.put(str22[i], map.get(str22[i])-1);
			}
		}
		for(int i =0;i<str22.length;i++){
			if(map.get(str22[i])!=0)
				return false;
		}
		return true;
	}
 
}








package CC150;

import java.util.Hashtable;


public class Solution {
	public static void main(String[] args) {
		// string no same size
		String str1 = "abcdfs";
		String str2 = "cba";
		System.out.println(isPermutation(str1, str2));
		// String same size but not permutaion
		str1 = "fasfasfsahf;uip";
		str2 = "fasfasfsahfauip";
		System.out.println(isPermutation(str1, str2));
		// two null String
		str1 = null;
		str2 = null;
		System.out.println(isPermutation(str1, str2));
		// two empty String
		str1 = "";
		str2 = "";
		System.out.println(isPermutation(str1, str2));
		// two permutaion String
		str1 = "asdfghjkl;l";
		str2 = "asdfghjkl;l";
		System.out.println(isPermutation(str1, str2));
 
	}
 
	private static boolean isPermutation(String str1, String str2) {
		
	}
 
}

