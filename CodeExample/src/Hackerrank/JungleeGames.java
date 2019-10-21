package Hackerrank;

import java.util.Stack;

public class JungleeGames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="a+b";
       System.out.println(checkRedundancy(str));
       System.out.println(fun(str));
	}
	
	static boolean  fun(String equation) {
		System.out.println(equation.matches(".*(.).*"));
		 if(equation.indexOf("((") >=0 || equation.indexOf("))") >=0 || equation.matches("(.)") ) {
	            return true;
	        }else{
	            return false;
	        }

	}
	
	static boolean checkRedundancy(String equation) { 
        
        Stack<Character> stack = new Stack<>(); 
        char[] str = equation.toCharArray(); 
         for (char ch : str) { 
            if (ch == ')') { 
                char top = stack.peek(); 
                stack.pop(); 
                boolean f = true;
                while (top != '(') { 
                      if (top == '-' || top == '+' || top == '/' || top == '/') { 
                        f = false; 
                    } 
                    top = stack.peek(); 
                    stack.pop(); 
                } 
                if (f == true) {  
                    return true; 
                } 
            } else { 
                stack.push(ch); 
            }                
        } 
        return false; 
    } 
  

}
