package Hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArraysQuery {
	static int maxN=300001;
	static Long count=0l;
	static class Pair{
		long first;
		long second;
		
	}
	static Map<Integer,Pair> setMap=new TreeMap<Integer,Pair>();
	static List<Integer> set=new ArrayList<>(maxN);
	static List<Pair> indexList=new ArrayList<>(maxN);
	
	static int arrayAndQueries(int[] A, int[][] queries) {
        // Complete this function
		Long result=0l;
		int n=A.length;
		for(int i=0;i<n;i++)
		{
			Pair pair=new Pair();
			pair.first=A[i];
			pair.second=i;
			indexList.add(pair);
		}
		Collections.sort(indexList,new Comparator<Pair>(){
				@Override
		public int compare(Pair o1, Pair o2) {
			// TODO Auto-generated method stub
			
			return (int) (o1.first-o1.first);
		}});
		for(int i=0;i<n;i++)
		{
			Pair pair=indexList.get(i);
		     int size=setMap.size();
		     if(size == 0)
		     {
		    	    count++;
					Pair pair1=new Pair();
					pair1.first=pair.first;
					pair1.second=pair.first;
					//list.add(pair1);
					setMap.put((int)pair1.first, pair1);
					set.add((int)pair1.first);
		     }else
		     {
		    	 
		    	 Pair setPair=null;
		    	 if(setMap.containsKey(pair.first-1))
		    	 {
		    		 setPair=setMap.get(pair.first-1);
		    	 }
		    	 if(setPair !=null)
		    	 { 
		    		 Long max=setPair.first;
			    	
			    	 
			    		 setPair.first=max;
			    		 set.add((int)(pair.first-1));
			    		 
			    	 
		    	 }else
		    	 {
		    		 count++;
			    		Pair pair1=new Pair();
						pair1.first=pair.first;
						pair1.second=pair.first;
						setMap.put((int)(pair.first), pair1);
						set.add((int)pair1.first);
			    		
			    	
		    	 }
		    	 
		     }
			
		}
		for(int i=0;i<queries.length;i++)
		{
			int id=queries[i][0];
			int val=queries[i][1];
			
		}
		
		
		
		return result.intValue();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int q = in.nextInt();
        int[][] queries = new int[q][2];
        for(int queries_i = 0; queries_i < q; queries_i++){
            for(int queries_j = 0; queries_j < 2; queries_j++){
                queries[queries_i][queries_j] = in.nextInt();
            }
        }
        int result = arrayAndQueries(A, queries);
        System.out.println(result);
        in.close();

	}

}
