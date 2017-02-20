package Threading;

public class example1 extends Thread{
	example1(String  name)
	{
		super(name);
		start();
	}
	public void run()
	{
		System.out.println(" thread is running");
	}
	public static void main(String[] args)
	{
		example1 first=new example1("first thread");
		example1 first1=new example1("2 thread");
		
		example1 first2=new example1("3 thread");
		example1 first3=new example1("4 thread");
		System.out.println(first1.getName());
		System.out.println(first2.getName());
		System.out.println(first3.getName());
		System.out.println(first.getName());
		//first.run();
	}
	

}
