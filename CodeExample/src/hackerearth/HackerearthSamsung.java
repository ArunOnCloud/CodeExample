package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class HackerearthSamsung {
	
	static int block;
	 
	// Structure to represent a query range
	static class Query
	{
	    int L, R;
	};
	 
	// Function used to sort all queries so that all queries 
	// of same block are arranged together and within a block,
	// queries are sorted in increasing order of R values.
	boolean compare(Query x, Query y)
	{
	    // Different blocks, sort by block.
	    if (x.L/block != y.L/block)
	        return x.L/block < y.L/block;
	 
	    // Same block, sort by R value
	    return x.R < y.R;
	}
	 
	// Prints sum of all query ranges. m is number of queries
	// n is size of array a[].
	static Map<Long,Long> map=new TreeMap<>();
	static void queryResults(long a[], int n, Query q[], int m)
	{
	    // Find block size
	    block = (int)Math.sqrt(n);
	 
	    // Sort all queries so that queries of same blocks
	    // are arranged together.
	    Arrays.sort(q,(x,y)->{ if (x.L/block != y.L/block)
	        return x.L/block - y.L/block;
	 
	    // Same block, sort by R value
	    return x.R - y.R;});
	   // sort(q, q + m, compare);
	 
	    // Initialize current L, current R and current sum
	    int currL = 0, currR = 0;
	    long currSum = 0;
	 
	    // Traverse through all queries
	    for (int i=0; i<m; i++)
	    {
	        // L and R values of current range
	        int L = q[i].L, R = q[i].R;
	 
	        // Remove extra elements of previous range. For
	        // example if previous range is [0, 3] and current
	        // range is [2, 5], then a[0] and a[1] are subtracted
	        while (currL < L)
	        {
	            currSum -= a[currL];
	            if(map.containsKey(a[currL])){
	            	long key=map.get(a[currL]);
	            	map.put(a[currL], key+1);
	            }else{
	            	map.put(a[currL], 1l);
	            }
	            currL++;
	        }
	        
	 
	        // Add Elements of current Range
	        while (currL > L)
	        {
	            currSum += a[currL-1];
	            if(map.containsKey(a[currL-1])){
	            	long key=map.get(a[currL-1]);
	            	map.put(a[currL-1], key-1);
	            }else{
	            	map.put(a[currL-1], 1l);
	            }
	            currL--;
	        }
	        while (currR <= R)
	        {
	            currSum += a[currR];
	            if(map.containsKey(a[currR])){
	            	long key=map.get(a[currR]);
	            	map.put(a[currR], key+1);
	            }else{
	            	map.put(a[currR], 1l);
	            }
	            currR++;
	        }
	 
	        // Remove elements of previous range.  For example
	        // when previous range is [0, 10] and current range
	        // is [3, 8], then a[9] and a[10] are subtracted
	        while (currR > R+1)
	        {
	            currSum -= a[currR-1];
	            if(map.containsKey(a[currR-1])){
	            	long key=map.get(a[currR-1]);
	            	map.put(a[currR-1], key-1);
	            }else{
	            	map.put(a[currR-1], 1l);
	            }
	            currR--;
	        }
	        currSum=0;
	        for(Map.Entry<Long, Long> entry:map.entrySet()){
	        	if(entry.getValue()%2 == 1){
	        		currSum+= (entry.getKey() * entry.getValue());
	        	}
	        }
	        System.out.println(currSum);
	 
	        // Print sum of current range
	        /*cout << "Sum of [" << L << ", " << R
	             << "] is "  << currSum << endl;*/
	    }
	}

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		int n=Integer.parseInt(line);
		line=br.readLine();
		String[] sarr=line.split(" ");
	    long[] arr=new long[n];
		for(int i=0;i<n;i++){
			arr[i]=Long.parseLong(sarr[i]);
			//arr[i]=Integer.parseInt(sarr[i]);
		}
		line=br.readLine();
		int q=Integer.parseInt(line);
		Query[] qarr=new Query[q];
		for(int i=0;i<q;i++){
			line=br.readLine();
			sarr=line.split(" ");
			Query query=new Query();
			query.L=Integer.parseInt(sarr[0])-1;
			query.R=Integer.parseInt(sarr[1])-1;
			qarr[i]=query;
			
		}
		queryResults(arr,n,qarr,q);

	}

}
