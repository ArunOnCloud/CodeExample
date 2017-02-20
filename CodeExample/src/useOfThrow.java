/*
 * Name: Arun kumar Ram
 * Date:11 june 2015
 */
public class useOfThrow {
	public static void main(String args[]){
		System.out.println("before exception.");
		
		try{
			int arr[]={3,5,0,5,6,};
			//throw new ArrayIndexOutOfBoundsException();
			//int x=arr[23];
			try{
				
			
			
			int a,b;
			a=5;
			b=0;
			//throw new ArithmeticException();
			//int y=a/b;
			if(b==0)
			{
				System.out.println("befor throw");
			   throw new ArithmeticException();
			}
			
			}
			catch(ArithmeticException exe)
			{
				System.out.println("in inner catch");
				exe.printStackTrace();
			}
		}
		catch(ArrayIndexOutOfBoundsException | ArithmeticException e)
		{
			System.out.println("in catch");
			e.printStackTrace();
		}
		
	}

}
