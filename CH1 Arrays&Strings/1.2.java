//Implement a function to reverse a string
// time complexity O(n), space complexity O(n)
public Solution{
	public String reverseString(String str){
		String res = new String();
		if(str == null || str.length() == 0)
			return res;
		for(int i =0; i<str.length();i++)
		{
			res.charAt[i] = str.charAt(str.length() -i);
		}
		return res;
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
			str.charAt(str.length()-i) = str.charAt(i);
			str.charAt(i) = temp;
		}
		return str;
	}
}