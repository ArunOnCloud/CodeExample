package Hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class YatraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] values= {"{}[]()}","{[}]"};
		System.out.println(braces(values));

	}
	static int[] getMinimumDifference(String[] a, String[] b) {
        /*
         * Write your code here.
         */
		int n=a.length;
		int res[]=new int[n];
		for(int i=0;i<n;i++) {
			res[i]=util(a[i],b[i]);
		}
     return res;
    }
	/*static void findSubstrings(String s) {
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		res=new TreeSet<>();
		 util(s,"",-1,0);
		 //String[] result=res.toArray(a)
		 int n=res.size();
		 int ind=0;
		 for(String str:res) {
			 if(ind==0) {
				 System.out.println(res);
			 }
			 if(ind==n-1) {
				 System.out.println(res);
			 }
			 ind++;
		 }
		// System.out.println(res);
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		Map<Character,Integer> map=new TreeMap<>();
		for(int i=0;i<s.length();i++) {
			if(set.contains(s.charAt(i))) {
				if(!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), i);
			}
		}
		int fi=0;
		for(Map.Entry<Character, Integer> entry:map.entrySet()) {
			fi=entry.getValue();
			break;
		}
		int ei=0;
		
		for(Map.Entry<Character, Integer> entry:map.entrySet()) {
			ei=entry.getValue();
			break;
		}
		char ch='z';
		for(int i=fi+1;i<s.length();i++) {
			if(!set.contains(s.charAt(i)){
				if(s.charAt(i) <ch) {
					ch=s.charAt(i);
				}
				
			}
		   
		}
		System.out.println(s.charAt(fi)+ch);
		int[] arr=new int[s.length()];
		arr[s.length()-1]=(int)(s.charAt(s.length()-1) -'a');
		for(int i=s.length()-2;i>=0;i++) {
			int cur=(int)(s.charAt(i) -'a');
			if(cur> arr[i+1]) {
				arr[i]=cur;
			}else {
				arr[i]=arr[i+1];
			}
			
		}
		for(int i=ei;i<s.length();i++) {
			//if()
			//System.out.print
			
		}
		
		 

    }
	*/
	static Set<Character> set=new HashSet<>();
	static Set<String> res=new TreeSet<>();
	static void util(String s,String str,int i,int j){
	    int n=s.length();
	    if(j >= n){
	        return ;
	    }
	    if(i>=0){
	        if(!set.contains(s.charAt(j))){
	            String st=s.substring(j,j+1);
	            if(!res.contains(str+st)){
	                res.add(str+st);
	            }
	            //System.out.print(str+st+" ");
	            util(s,str+st,i,j+1);
	            util(s,str,i,j+1);
	        }else {
	           String st=s.substring(j,j+1);
	            
	            util(s,st,j,j+1);
	            util(s,str+st,i,j+1);
	            util(s,str,i,j+1);
	        }
	    }else{
	        if(!set.contains(s.charAt(j))){
	            String st=s.substring(j,j+1);
	            //System.out.println(str+st);
	            util(s,"",i,j+1);
	            util(s,"",i,j+1);
	        }else {
	           String st=s.substring(j,j+1);
	            
	            util(s,st,j,j+1);
	            util(s,str,i,j+1);
	        }
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int util(String a,String b) {
		int ans=0;
		if(a.length() != b.length()) {
			return -1;
		}
		int[] arra=new int[26];
		int[] arrb=new int[26];
		for(int i=0;i<a.length();i++) {
			int ind=(int)(a.charAt(i)-'a');
			arra[ind]++;
		}
		for(int i=0;i<b.length();i++) {
			int ind=(int)(b.charAt(i)-'a');
			arrb[ind]++;
		}
		for(int i=0;i<26;i++) {
			ans+= Math.abs(arra[i]-arrb[i]);
		}
		
		return ans/2;
	}
	
	static String[] braces(String[] values) {
        /*
         * Write your code here.
         
         */
        int n=values.length;
        String[] res=new String[n];
        for(int i=0;i<n;i++){
            boolean t=util(values[i]);
            if(t== true){
                res[i]="YES";
            }else{
                res[i]="NO";
            }
            
        }
        return res;

    }

static  boolean util(String str){
    Stack<Character> s=new Stack<>();
       // String str=values;
        boolean test=true;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            System.out.println("i"+i+" c:"+c);
            if(c == '(' || c=='{'|| c=='['){
                s.push(c);
            }
            
            if(c == '}'){
            	if(s.isEmpty()){
                    return false;
                }else{
                    
                }
                char t=s.pop();
                if(t != '{'){
                    test=false;
                    break;
                }
            }
            if(c == ']'){
            	if(s.isEmpty()){
                    return false;
                }else{
                    
                }
                char t=s.pop();
                if(t != '['){
                    test=false;
                    break;
                }
            }
            if(c == ')'){
            	if(s.isEmpty()){
                    return false;
                }else{
                    
                }
                char t=s.pop();
                if(t != '('){
                    test=false;
                    break;
                }
            }
            
            
        }
    if(s.isEmpty() && test){
        return true;
    }else{
        return false;
    }
    
}



}
