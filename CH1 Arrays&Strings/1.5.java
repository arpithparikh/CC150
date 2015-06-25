// Implement a method to perform basic string compression using the counts of repeated characters.
//  For example, the string aabcccccaaa would become a2blc5a3. 
//  If the “compressed” string would not become smaller than the original string, 
//  your method should return the original string.
package CC150;
public class Solution {
	
	public static String compress(String str) {
		StringBuilder res = new StringBuilder();
		char[] str1 = str.toCharArray();
		char check = str1[0];
		int count = 1;
		for(int i =1;i<str1.length;i++){
			if(str1[i] == check)
				count++;
			else
			{
				res.append(check+"");
				res.append(count);
				check = str1[i];
				count = 1;
			}
		}
		if(res.toString().length() > str.length())
			return str;
		else
			return res.toString();
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "aabcccccaaa";
		System.out.println(compress(test));
		String test1 = "       ";
		System.out.println(compress(test1));
		String test2 = "zhangxinshidiaomiMa";
		System.out.println(compress(test2));
		String test3 = "TaShiDiaoBi";
		System.out.println(compress(test3));
		String test4 = "aaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbssssssssssssssssssssssssssssssssssssssssssssssssss";
		System.out.println(compress(test4));
	}
 
}