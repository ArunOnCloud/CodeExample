package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class InfixToPostfixConversion {
	static Map<Character,Integer> map=new HashMap<>();
    static Stack<Character> stack=new Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="a+b*(c^d-e)^(f+g*h)-i";
		map.put('^', 0);
		map.put('*', 1);
		map.put('/', 2);
		map.put('+', 3);
		map.put('-', 4);
		Set<Character> set=map.keySet();
		String res="";
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(set.contains(c)) {
		        
			}else {
				if(!stack.isEmpty()) {
				    Character ch=stack.pop();
				    res+=ch;
				}else {
					
				}
			}
		}
		

	}
	

}
