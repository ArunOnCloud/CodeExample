package Hackerrank;

public class WorldPay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double d= 10.0/-0;
		int c=-1;
		try{
			c=2/0;
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			System.out.println("finally");
		}
		if(d==Double.POSITIVE_INFINITY)
		{
			System.out.println("pos");
		}else
		{
			System.out.println(" adf");
		}
		String s="";
		

	}

}
/*class A{
	int b;
	public void add(int a)
	{
		 a++;
	}
	A(int x):b(x){};
}
class B extends A{
	B(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(int a)
	{
		 a--;
	}
}
*/