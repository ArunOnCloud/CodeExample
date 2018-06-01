package interviewbit;

import java.util.ArrayList;
import java.util.Comparator;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioning palindromePartitioning=new PalindromePartitioning();
		palindromePartitioning.partition("aab");
		System.out.println(palindromePartitioning.result);
	}
	ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
	public ArrayList<ArrayList<String>> partition(String a) {
		util(a,0,0,new ArrayList<String>());
		//result.sort(Comparator.naturalOrder());
		return result;
	}
	public void util(String s,int i,int j,ArrayList<String> res){
		int n=s.length();
		if(i>=n || j>=n) {
			return;
		}
		if(isPalindrome(s, i, j) && j==n-1) {
			res.add(s.substring(i, j+1));
			result.add(res);
			return;
		}
		if(isPalindrome(s, i, j)) {
			String str=s.substring(i, j+1);
			
			ArrayList<String> copy=new ArrayList<>();
			for(int i1=0;i1<res.size();i1++) {
				copy.add(res.get(i1));
			}
			//result.add(copy);
			res.add(str);
			util(s,j+1,j+1,res);
			util(s,i,j+1,copy);
		}else {
			util(s,i,j+1,res);
		}
	    
	}
	public boolean isPalindrome(String s,int i,int j) {
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
