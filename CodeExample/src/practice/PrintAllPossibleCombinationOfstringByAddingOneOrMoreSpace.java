package practice;

public class PrintAllPossibleCombinationOfstringByAddingOneOrMoreSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     fun("abcd",1);
	}
	
	public static void fun(String result,int ind)
	{
		if(ind==result.length())
		{
			System.out.println(result);
		}else
		{
			String left= result.substring(0, ind);
			String right =result.substring(ind,result.length());
			fun(result,ind+1);
			fun(left+" "+right,ind+2);
			
		}
	}

}
