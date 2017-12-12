package Hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;



class Ubona1 {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
         * 
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
           // Writing output to STDOUT
        int t=Integer.parseInt(line);
       for(int i=0;i<t;i++)
       {
    	   line=br.readLine();
    	   System.out.println(fun(line.trim()));
       }

        // Write your code here

    }
    static long fun(String s)
    {
    	long res=1l;
    	Map<Character,Long> map=new HashMap<Character,Long>();
    	map.put('a', 0l);
    	map.put('e', 0l);
    	map.put('i', 0l);
    	map.put('o', 0l);
    	map.put('u', 0l);
    	long count=0;
    	for(int i=0;i<s.length();i++)
    	{
    		if(map.containsKey(s.charAt(i)))
    		{
    			if(map.get(s.charAt(i)) == 0)
    			{
    				map.put(s.charAt(i), 1l);
    				count++;
    			}else
    			{
    				
    			}
    		}else if(s.charAt(i)=='_')
    		{
    			if(count>0)
    			{
    				res*=count;
    			}
    		}
    	}
    	
    	return res;
    }
}

