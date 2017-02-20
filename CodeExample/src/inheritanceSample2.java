class base
{
	base(){
		System.out.println("base Constructor is called");
	}
}
class derive extends base{
	derive()
	{
		System.out.println("Derived constructor is called");
	}
}
public class inheritanceSample2 {
	public static void main(String args[]){
		derive obj=new derive();
	}

}
