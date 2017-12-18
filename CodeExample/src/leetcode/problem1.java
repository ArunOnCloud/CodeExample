package leetcode;

import java.util.Arrays;
import java.util.Comparator;
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