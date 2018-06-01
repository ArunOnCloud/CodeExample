package geeksforgeeks;

/*public class PrintingSubsequeceWithVowelAndConsonant {

}*/
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class PrintingSubsequeceWithVowelAndConsonant {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
	//	sc.nextLine();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		while(t>0){
		    String line=br.readLine();
		    //System.out.println(line);
		    util(line,"",-1,0);
		    for(String str:res){
		        System.out.print(str+" ");
		    }
		    if(res.size() == 0){
		        System.out.print(-1);
		    }
		    //System.out.println(res);
		    System.out.println();
		    res=new TreeSet<>();
		    t--;
		}
		
	}
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
}
