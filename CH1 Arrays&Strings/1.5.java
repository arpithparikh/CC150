// Implement a method to perform basic string compression using the counts of repeated characters.
//  For example, the string aabcccccaaa would become a2blc5a3. 
//  If the “compressed” string would not become smaller than the original string, 
//  your method should return the original string.
public class Solution{
	public String compressString(string str){
		StringBuffer res = new StringBuffer();
		char[] str = str.toCharArray();
		char check = str1[0];
		int count = 1;
		for(i = 1; i < str.length; i++)
		{
			if(str[i] == check)
				count++;
			else
			{
				res.append((check + ""), count);
				check = str[i];
				count = 1;
			}
		}
		
		if(res.toString().length() > str.length)
			return str;
		else
			return res;
	}
}