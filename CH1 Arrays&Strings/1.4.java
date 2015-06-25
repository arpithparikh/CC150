//Write a method to replace all spaces in a string with '%20'
//Bacause the String in Java is immutable, so we will use characters array
package CC150;
public class Solution {
	 
	public static void main(String[] args) {
		//assume  input string is not null and have enough space to 
		char[] str = {'m','r',' ',' ','m','r',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
		String result = Solution(str,6);
		System.out.println(result);
		 str = new char[] {'m','r',' ',' ','m','r','m','r',' ','m','r',' ','m','r',' ','m','r',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
		 result = Solution(str,17);
		System.out.println(result);
		 str = new char[] {'m','r',' ',' ',' ','m','r','m','r',' ','m','r',' ','m','r',' ','m','r',' ',' ','s','m','i','t','h',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
		 result = Solution(str,25);
		System.out.println(result);
	}
	private static String Solution(char[] string,int length) {
		if(string == null || string.length==0)
			return String.valueOf(string);
		int count = 0;
		for(int i =0;i<length;i++)
		{
			if(string[i] == ' ')
				count++;
		}
		char[] res = new char[length + 2*count];
		int newLength = length + 2*count;
		for(int i = length-1;i>=0;i--)
		{
			if(string[i] == ' ')
			{
				res[newLength-1] = '0';
				res[newLength-2] = '2';
				res[newLength-3] = '%';
				newLength = newLength-3;
			}
			
			else{
				res[newLength-1] = string[i];
				newLength = newLength-1;
			}
		}
		return String.valueOf(res);
	}
}