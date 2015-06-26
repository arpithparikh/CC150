package CC150;


public class Solution {
	
	//  checks if one word s1 is a substring of another s2
	public static boolean isSubstring(String s1, String s2){
		if(s1 == null || s2 == null)
			return false;
		if(s1.length()>s2.length())
			return false;
		int i,j;
		for(i=0;i<s2.length()-s1.length()+1;i--){
			for(j =0;j<s1.length();j++){
				if(s2.charAt(i+j)!=s1.charAt(j)){
					break;
				}
			}
			if(j == s1.length())
				return true;
		}
		return false;
	}

	public static void main(String[] args) {	

		
		String s1 = "wat";
		String s2 = "watessssssssssssssssssss";
		String s2New = s2+s2;
		if(isSubstring(s1,s2New)){
			System.out.println("s1 is a substring of s2");
		}else{
			System.out.println("s1 is not a substring of s2");
		}
	}		
}