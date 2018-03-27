package Hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Flipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  System.out.println(	util("ZZZZZZZZ"));
	  
	  //System.out.println(programmerStrings("progxrammerrxproxgrammer"));
	 // System.out.println(programmerStrings("programmerxprogrammer"));
	  

	}
	
	static int excelLine(String x1, String y1, String x2, String y2) {
        // Write your code here.
        long x11=Long.parseLong(x1);
        long y11=(util(y1));
        long x12=Long.parseLong(x2);
        long y12=util(y2);
        
        
        long slope= (y12-y11)/(x12-x11);
        long c=(slope*x11) -y11;
        if(c==0)
        {
        	return 1;
        	
        }else
        {
        	return 0;
        }


    }
	
	
	public static long util(String columnName)
	{
	    

	    columnName = columnName.toUpperCase();

	    long sum = 0l;

	    for (int i = 0; i < columnName.length(); i++)
	    {
	        sum *= 26;
	        sum += (columnName.charAt(i) - 'A' + 1);
	    }

	    return sum;
	}
	
	static int programmerStrings(String s) {
		int ans=0;
		Map<Character,Integer> ml=new HashMap<>();
		Map<Character,Integer> mr=new HashMap<>();
		Map<Character,Integer> res=new HashMap<>();
		Map<Character,Integer> result=new HashMap<>();
		String str="programmer";
		for(int i=0;i<str.length();i++)
		{
			Character ch=str.charAt(i);
			if(result.containsKey(ch))
			{
				Integer c=result.get(ch);
				result.put(ch, c+1);
			}else
			{
				result.put(ch, 1);
			}
		}
		System.out.println("result:"+result);
		for(int i=0;i<s.length();i++)
		{
			Character ch=s.charAt(i);
			if(res.containsKey(ch))
			{
				Integer c=res.get(ch);
				res.put(ch, c+1);
			}else
			{
				res.put(ch, 1);
			}
		}
		for(int i=0;i<s.length();i++)
		{
			Character ch=s.charAt(i);
			if(mr.containsKey(ch))
			{
				Integer c=mr.get(ch);
				mr.put(ch, c+1);
			}else
			{
				mr.put(ch, 1);
			}
		}
		for(int i=0;i<s.length();i++)
		{
			Character ch=s.charAt(i);
			if(result.containsKey(ch))
			{
				if(ml.containsKey(ch))
				{
					Integer c=ml.get(ch);
					ml.put(ch, c+1);
					Integer count=res.get(ch);
					mr.put(ch, count-c-1);
					
				}else
				{
					ml.put(ch, 1);
					Integer count=res.get(ch);
					mr.put(ch, count-1);
				}
			}
			System.out.println("ml:"+ml);
			System.out.println("mr:"+mr);
			if(util(ml,mr,result)) {
				System.out.println("i:"+i);
				ans++;
			}
		}
		
		
		
		return ans;

    }
	static boolean util(Map<Character,Integer> ml,Map<Character,Integer> mr,Map<Character,Integer> result) {
		boolean res=true;
		for(Map.Entry<Character, Integer> entry: result.entrySet()) {
			Character ch=entry.getKey();
			Integer val= entry.getValue();
			if(ml.containsKey(ch) ) {
				if(ml.get(ch) < val) {
					return false;
				}
			}else {
				return false;
			}
			if(mr.containsKey(ch) ) {
				if(mr.get(ch) < val) {
					return false;
				}
			}else {
				return false;
			}
		}
		return true;
	}


}
