package interviewbit;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Fraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fraction faction=new Fraction();
		System.out.println(faction.fractionToDecimal(87, 22));
		
		System.out.println("val:"+faction.fractionToDecimal(1, 29876));

	}
	public String fractionToDecimal(int A, int B) {
		String str="";
		Double  a=(double)A;
		Double b=(double)B;
		Double c= a/b;
		
		if(Double.isNaN(c)) {
			return c.toString();
		}else if(Double.isInfinite(c))
		{
			return c.toString();
		}else {
			//System.out.println(" asdf");
			if(recur(A, B).length() == 0) {
				if(A%B == 0) {
					Integer res= A/B;
					str= res.toString();
				}else {
					str= c.toString();
					str=new BigDecimal(c).toPlainString();
				}
				
				
			}else {
				Integer res= A/B;
				//System.out.println("c:"+c);
				//str=new BigDecimal(c).toPlainString();
				//String str1=new String(str);
				//str= str.substring(0,str1.indexOf(recur(A, B)));
				//System.out.println("c:"+str);
				//str=str.replaceAll( recur(A, B),"");
				 //str= str + "(" + recur(A, B)+ ")";
				str=res.toString() +"."+recur(A, B);
			}
		}
		str=str.replaceAll("-", "");
	//	System.out.println(str);
		if(str.indexOf(".")>0)
		{
		    //str=new BigDecimal(Double.parseDouble(str)).toPlainString();
		}
		if(str.equals("0")){
		    return str;
		}else if(A < 0 && B< 0) {
			return str;
		}else if((A < 0 && B> 0) || (A > 0 && B< 0)){
			return "-"+str;
		}
		
		
		return str;
    }
	
	private static String recur(int numr, int denr) {

		StringBuilder res=new StringBuilder("");

		Map<Integer,Integer> mp = new TreeMap<>();

		int rem = numr%denr;

		while((rem!=0) && (!mp.containsKey(rem))){

		mp.put(rem, res.length());

		rem=rem*10;

		int res_Part=rem/denr;

		res.append(Integer.toString(res_Part));

		rem=rem%denr;

		}

		if (rem==0) {
		  return	"";
		}else {
			String str1=res.substring(0,mp.get(rem));
			String str2=res.substring(mp.get(rem));
			String res1=str1+"("+str2+")";
			//System.out.println(res1);
			return str1+"("+str2+")";
		}

		}
	
	public int lengthOfLongestSubstring(String A) {
		StringBuilder sb=new StringBuilder(A);
		int res=0;
		for(int i=0;i<sb.length();i++) {
			for(int j=i+1;j<sb.length();j++) {
				if(isDistinct(sb, i, j)) {
					int len=j-i+1;
					if(len>res) {
						res=len;
					}
				}
			}
		}
		
		
		return 0;
	    
    }
	boolean isDistinct(StringBuilder sb,int i,int j) {
		boolean res=true;
		Set<Character> set=new HashSet<>();
		for(int x=i;x<=j;x++) {
			Character c=sb.charAt(x);
			if(set.contains(c)) {
				return false;
			}else {
				set.add(c);
			}
			
		}
		
		return res;
		
	}

}
