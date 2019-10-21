package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr=new int[4][5];
		int[][] ar={ {3,4} , {2,3}, {1,2}};
		System.out.println(arr.length);
		Arrays.sort(ar,new PairComparator());
		for(int i=0;i<3;i++)
		{
			System.out.println(ar[i][0]+ " "+ ar[i][1]);
		}
		System.out.println(ar);
		//[[3,4],[2,3],[1,2]]
		String[] array=new String[5];
		//Collections.EMPTY_LIST
		String par="Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned=new String[]{"hit"};
		mostCommonWord(par, banned);

	}
	
	public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> map=new HashMap<>();
        
        String par=paragraph.toLowerCase().replaceAll("\\."," ");
        //!?',;.
        par=par.toLowerCase().replaceAll(","," ");
        par=par.toLowerCase().replaceAll("!"," ");
        par=par.toLowerCase().replaceAll("?"," ");
        par=par.toLowerCase().replaceAll("'"," ");
        par=par.toLowerCase().replaceAll(";"," ");
        String[] words=par.split(" ");
        for(String word:words){
            System.out.println(word);
            Integer val=map.get(word);
            if(val == null){
                map.put(word,1);
            }else{
                map.put(word,val+1);
            }
            
        }
        
        for(String word:banned){
            if(map.containsKey(word)){
                map.remove(word);
            }
        }
        String ans="";
        int count=0;
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue() >count){
                ans=entry.getKey();
                count=entry.getValue();
            }
        }
        return ans;
        
    }
	
public int countSubstrings(String s) {
	    int n=s.length();
        int[] ans=new int[s.length()];
        for(int i=0;i<n;i++)
        	ans[i]=1;
        
        for(int i=1;i<n;i++)
        {
        	int count=1;
        	for(int j=i-1;j>=0;j--)
        	{
        		if(isPalindrome(s, j, i))
        		{
        			count++;
        		}
        	}
        	ans[i]=ans[i-1]+count;
        }
        return ans[n-1];
        
    }
boolean isPalindrome(String s,int i,int j)
{
	
	while(i<j)
	{
		if(s.charAt(i) != s.charAt(j))
		{
			return false;
		}
		i++;
		j--;
	}
	return true;
}
	
	
public int[] findErrorNums(int[] nums) {
        
        Arrays.sort(nums);
        int m=0;
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<nums.length-1;i++)
        {
            map.put(nums[i],1);
        }
        for(int i=0;i<nums.length-1;i++)
        {
            if(map.containsKey(i+1) == false)
            {
                m=i+1;
                break;
            }
        }
        int d=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                d=nums[i];
                break;
            }
        }
        int[] res=new int[2];
        res[0]=d;
        res[1]=m;
        
        return res;
    }

}
class PairComparator implements Comparator<int[]>
{

	@Override
	public int compare(int[] arg0, int[] arg1) {
		// TODO Auto-generated method stub
		return arg0[0]-arg1[0];
		
		
	}
	
}