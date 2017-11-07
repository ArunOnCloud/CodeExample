package practice;
import java.util.*;

public class LeetcodeMergeAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public List<List<String>> accountsMerge(List<List<String>> accounts) {
		 List<List<String>>  result=new LinkedList<List<String> >();
     //Map<String,Set<Integer> > map=new TreeMap<String, Set<Integer> >();
		 Map<Integer,Set<String> > map=new TreeMap<Integer,Set<String> >();
		 Map<Integer,String> nameMap=new TreeMap<Integer,String>();
     boolean[] arr=new boolean[accounts.size()];
     for(int i=0;i<accounts.size();i++)
     {
    	 if(arr[i]==true)
    	 {
    		 continue;
    	 }
    	 List<String> account=accounts.get(i);
    	 
    	 Set<String> set=new TreeSet<String>();
    	 for(int i1=1;i1<account.size();i1++)
    	 {
    		 set.add(account.get(i1));
    	 }
    	 map.put(i, set);
    	 nameMap.put(i, account.get(0));
    	 for(int j=1;j<account.size();j++)
    	 {
    		 String email=account.get(j);
    		 for(int k=i+1;k<accounts.size();k++)
    		 {
    			 List<String> accountsearch=accounts.get(k);
    			 int t=0;
    			 for(int l=1;l<accountsearch.size();l++)
    			 {
    				 if(email.equals(accountsearch.get(l)))
    				 {
    					 t=1;
    					 break;
    				 }
    			 }
    			 if(t==1)
    			 {
    				 for(int l=1;l<accountsearch.size();l++)
        			 {
        				 if(!set.contains(accountsearch.get(l)))
        				 {
        					 set.add(accountsearch.get(l));
        				 }
        			 }
    				 arr[k]=true;
    				
    			 }
    		 }
    	 }
    	 
     }
     for(Map.Entry<Integer, Set<String>> entry:map.entrySet())
     {
    	 Object[] a=(Object[]) entry.getValue().toArray();
    	 Integer key=entry.getKey();
    	 List<String> list=new LinkedList<String>();
    	 for(int i=0;i<a.length;i++)
    	 {
    		 list.add(a[i].toString());
    	 }
    	 Collections.sort(list);
    	 list.add(0, nameMap.get(key));
    	 result.add(list);
     }
     
     return result;
     
        
    }
	public void util(List<List<String>> accounts,Set<String> set,int i)
	{
		 for( i=i;i<accounts.size();i++)
	     {
	    	
	    	 List<String> account=accounts.get(i);
	    	 
	    	
	    	 for(int i1=1;i1<account.size();i1++)
	    	 {
	    		 set.add(account.get(i1));
	    	 }
	    	 for(int j=1;j<account.size();j++)
	    	 {
	    		 String email=account.get(j);
	    		 for(int k=i+1;k<accounts.size();k++)
	    		 {
	    			 List<String> accountsearch=accounts.get(k);
	    			 int t=0;
	    			 for(int l=1;l<accountsearch.size();l++)
	    			 {
	    				 if(email.equals(accountsearch.get(l)))
	    				 {
	    					 t=1;
	    					 break;
	    				 }
	    			 }
	    			 if(t==1)
	    			 {
	    				 for(int l=1;l<accountsearch.size();l++)
	        			 {
	        				 if(!set.contains(accountsearch.get(l)))
	        				 {
	        					 set.add(accountsearch.get(l));
	        				 }
	        			 }
	    				 
	    				
	    			 }
	    		 }
	    	 }
	    	 
	     }
	}

}
