
public class staticTesting {

	public static void main(String[] args) {
		Static obj=new Static();
		Static.x=5;
		System.out.println("val:"+obj.val);
		System.out.println("x:"+Static.x);
		Static obj2=new Static();
		obj2.val=12334;
		System.out.println("obj2 val:"+obj2.val);
		
	
	}
		


	
}
class Static{
		static int x;
		double val;
		Static()
		{
			val=0;
		}
}