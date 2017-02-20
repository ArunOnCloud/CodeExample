import java.util.*;
public class code2 {
	public static int add(int a,int b)
	  {
		  return a+b;
	  }
	  public static void main(String args[])
	  {
		  int a=2;
		  int b=13;
		  int c=a*b;
		  //c=add(a,b);
		  integer temp=new integer(12345);
		  c=temp.get();
		  System.out.println("a+b:"+c );
		  
	  }
	  

}
class integer
{
	private int a;
	integer(int a)
	{
		this.a=a;
	}
	public int get()
	{
		return a;
	}
}
