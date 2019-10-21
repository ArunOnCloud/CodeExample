package geeksforgeeks;

import java.util.HashSet;
import java.util.Set;

public class PrintAllValidParenthesis {
	Set<String> set=new HashSet<>();
	public static void main(String[] args) {
		PrintAllValidParenthesis parenthesis=new PrintAllValidParenthesis();
		parenthesis.print(3);
	}
	
	
	void print(int n) {
		util("()",1,n);
		System.out.println(set);
	}
	
	void util(String s,int ind,int n) {
		if(ind == n) {
			set.add(s);
			
			return;
		}
		for(int i=0;i<s.length();i++) {
			String str=s.substring(0, i)+ "()"+s.substring(i,s.length());
			util(str,ind+1,n);
		}
	}

}
