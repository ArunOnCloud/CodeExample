class A{
	 static int x;
	A()
	{
		x=10;
		System.out.println("A constructor");
	}
}
class B extends A{
	public int y;
	B(){
		y=100;
		System.out.println("B constructor");
	}
}
class C extends B{
	public int z;
	C(){
		System.out.println("C constructor");
	}
}
public class inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b=new B();
		System.out.println("Y:"+b.y);
		System.out.println("X:"+b.x);
		C c=new C();
		System.out.println("z:"+c.z);

	}

}
