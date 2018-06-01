package Hackerrank;

import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Pattern.matches(".s", "as"));//true (2nd char is s)  
		System.out.println(Pattern.matches(".s", "mk"));//false (2nd char is not s)  
		System.out.println(Pattern.matches(".s", "mst"));//false (has more than 2 char)  
		System.out.println(Pattern.matches(".s", "amms"));//false (has more than 2 char)  
		System.out.println(Pattern.matches("..s", "mas"));//true (3rd char is s)  

		//String pat="Ph*p?";
		String pat="";
		String str="";
		//String str="Phone";
		String pat1=pat.replaceAll("\\?", ".{0,2}");
		System.out.println(pat1);
		String pat2=pat1.replaceAll("\\*", ".*?...+.*");
		//System.out.println(pat.replaceAll("\\*", ".*?..+.*"));
		System.out.println(pat2);
		System.out.println(Pattern.matches(pat2, str));
	}

}
