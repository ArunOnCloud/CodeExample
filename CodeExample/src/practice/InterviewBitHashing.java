package practice;
import java.util.*;

public class InterviewBitHashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={2,3,4};
		System.out.println(a[0] + a[2]+ a[1]+ "");

	}
	
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    	HashMap<CusStr, Integer> tempMap=new HashMap<InterviewBitHashing.CusStr, Integer>();
    	for(int i=0;i<A.size();i++)
    	{
    		String str=A.get(i);
    		CusStr cusStr=new CusStr(str);
    		if(tempMap.containsKey(cusStr))
    		{
    			result.get(tempMap.get(cusStr)).add(i+1);
    		}else
    		{
    			ArrayList<Integer> list=new ArrayList<Integer>();
    			list.add(i+1);
    			result.add(list);
    			tempMap.put(cusStr, result.size());
    		}
    	}
    	
    	return result;
        
    }
    
   private class CusStr{
	   String data="";
	   Map<Character,Integer> map=null;
       public CusStr(String str){
    	   this.data=str;
    	   map=new HashMap<Character,Integer>();
    	   int n=str.length();
    	   for(int i=0;i<n;i++)
		   {
			   if(map.containsKey(str.charAt(i)))
			   {
				   int count=map.get(str.charAt(i));
				   map.put(str.charAt(i), count+1);
			   }else
			   {
				   map.put(str.charAt(i), 1);
			   }
		   }
    	   
       }
       
       @Override 
       public int hashCode() {
           int h =0;
           char[] value= data.toCharArray();
           if (h == 0 && value.length > 0) {
               char val[] = value;

               for (int i = 0; i < value.length; i++) {
                   h =  h + val[i];
               }
               
           }
           String str="//.";
           return h;
       }

       @Override
       public boolean equals(Object obj){
    	   boolean res=false;
    	   if(this == obj)
    	   {
    		   return true;
    	   }
    	   if(obj instanceof CusStr)
    	   {
    		   CusStr strTemp=(CusStr)obj;
    		   String str=strTemp.data;
    		   int n=str.length();
    		   if(n== data.length())
    		   {
    			   HashMap<Character,Integer> cusMap=new HashMap<Character,Integer>();
    			   for(int i=0;i<n;i++)
    			   {
    				   if(cusMap.containsKey(str.charAt(i)))
    				   {
    					   int count=cusMap.get(str.charAt(i));
    					   cusMap.put(str.charAt(i), count+1);
    				   }else
    				   {
    					   cusMap.put(str.charAt(i), 1);
    				   }
    			   }
    			   for(Map.Entry<Character, Integer> entry: cusMap.entrySet())
    			   {
    				   if(map.containsKey(entry.getKey()) && map.get(entry.getKey()) == entry.getValue())
    				   {
    					   
    				   }else
    				   {
    					   return false;
    				   }
    			   }
    			   
    			   
    			   return true;
    		   }else
    		   {
    			   return false;
    		   }
    	   }
    	   return res;
       }
       
   }

}
