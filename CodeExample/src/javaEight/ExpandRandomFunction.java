package javaEight;

import java.util.Random;

public class ExpandRandomFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       for(int i=0;i<5;i++)
       {
    	  System.out.println(rand7());
    	  // Math.random();
       }
	}
	
	public static int rand5()
	{
		
		double r=Math.random();
		Double temp=5*r;
		int res=temp.intValue()+1;
		//System.out.println("res:"+res);
		return res;
		
	}
	public static int rand7()
	{
		while(true)
		{
			int n= 5*(rand5()-1) + rand5() +1;
			System.out.println("n:"+n);
			if(n<=21)
			{
				return n%7 +1;
			}
		}
	}

}
