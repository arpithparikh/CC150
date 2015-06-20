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
public class Solution{
	public boolean isUnique(String str){
		if(str == null || str.length()<0||str.length()>128)
			return false;
		boolean check = new boolean[256];
		for(int i =0;i<str.length();i++)
		{
			if(boolean[str.charAt(i)])
				return false;
			else
				check[str.charAt(i)] = true;
		}
		return true;
	}
}