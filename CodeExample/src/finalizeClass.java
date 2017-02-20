/*
 * author: Arun Kumar Ram
 * Date: 8 june 2015
 * use of finalize() method
 */
public class finalizeClass {
	public static void main(String args[]){
		demo obj=new demo();
		for(int i=0;i<1000000;i++)
		{
			demo obj1=new demo();
		}
		System.out.println("fininsh");
		
	}

}
class demo{
	int x;
	int y;
	demo()
	{
		x=1;
		y=2;
	}
	protected void finalize()
	{
		System.out.println("Finalizing ");
	}
}
