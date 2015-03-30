//Write a method to replace all spaces in a string with '%20'
//Bacause the String in Java is immutable, so we will use characters array
public class Solution{
	public void replaceSpace(char[] str, int length){
		if(str == null || str.length == 0)
			return;
		int count =0;
		for(int i = 0;i <str.length;i++)
		{
			if(str[i] == ' ')
				count++;
		}
		int newLength = str.length + 2*count;
		for(int i = str.length -1; i>=0;i--)
		{
			if(str[i] == ‘ ’)
			{
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			}
			else
			{
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}
}
public class Solution{
	public void replaceSpace(char[] string, int length){
		if(string == null || string.length == 0)
			return;
		int count = 0;
		length = string.length ;
		for(int i =0; i<length;i++)
		{
			if(string[i] == ' ');
			count++;
		}
		int newLength = length + 2*count;
		for(int i = length -1; i>=0;i--)
		{
			if(string[i] != ' ')
			{
				string[newLength -1] = string[i];
				newLength = newLength -1;
			}
			else
			{
				string[newLength - 1] = '0';
				string[newLength - 2] = '2';
				string[newLength - 3] = '%';
				newLength = newLength -3;
			}
		}
	}
}