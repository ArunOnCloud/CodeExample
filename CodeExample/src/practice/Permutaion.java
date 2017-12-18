package practice;

public class Permutaion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        StringBuilder s=new StringBuilder("abc");
        fun(s,0);
	}
	
	public static void fun(StringBuilder s,int ind)
	{
		//System.out.println("ind:"+ind);
		if(ind==s.length())
		{
			System.out.println(s);
			return;
		}else
		{
			for(int i=ind;i<s.length();i++)
			{
				//s.setCharAt(i, arg1);
				//System.out.println("i:"+i);
				swap(s,i,ind);
				fun(s,ind+1);
				swap(s,i,ind);
			}
		}
	}
	
	public static void swap(StringBuilder s,int x,int y)
	{
		char temp=s.charAt(x);
		s.setCharAt(x, s.charAt(y));
		s.setCharAt(y, temp);
	}

}
