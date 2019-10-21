package geeksforgeeks;
import java.util.*;
import java.lang.*;
import java.io.*;

public class SecondMostRepetedStringInSequence {
	public static void main (String[] args) {
		//code
		Scanner sc1=new Scanner(System.in);
		Map<String,Integer> mc=new TreeMap<>();
		Map<String,Integer> mi=new TreeMap<>();
		int t=sc1.nextInt();
		while(t>0){
		    int n=sc1.nextInt();
		    String str1=sc1.nextLine();
		    String[] arr=str1.trim().split(" ");
		    System.out.println("n:"+n);
		    System.out.println("len:"+arr.length);
		    for(int i=0;i<n;i++){
		        String str=arr[i];
		      // String str=sc1.nextLine();
		        if(mc.containsKey(str)){
		            Integer val=mc.get(str);
		            mc.put(str,val+1);
		        }else{
		            mc.put(str,1);
		            mi.put(str,i);
		        }
		        
		    }
		    String first="";
		    Integer count=0;
		    Integer ind=999999999;
		    for(Map.Entry<String,Integer> entry:mc.entrySet()){
		        String str=entry.getKey();
		        Integer val=entry.getValue();
		        Integer index=mi.get(str);
		        if(val >count){
		            first=str;
		            count=val;
		            ind=index;
		        }else if(val == count && index< ind){
		            first=str;
		            count=val;
		            ind=index;
		        }
		    }
		    String ss="";
		    Integer sc=0;
		    Integer si=99999999;
		    for(Map.Entry<String,Integer> entry:mc.entrySet()){
		        String str=entry.getKey();
		        Integer val=entry.getValue();
		        Integer index=mi.get(str);
		        if(val >sc  && ind !=index){
		            ss=str;
		            sc=val;
		            si=index;
		        }else if(val == sc && index< si && ind!=index ){
		            first=str;
		            count=val;
		            ind=index;
		        }
		    }
		    System.out.println(ss);
		    
		    t--;
		}
	}
}