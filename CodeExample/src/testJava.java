import java.util.LinkedHashMap;

class pair
 {
	 public int x;
	 public int y;
	 
 }

public class testJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* String str="7";
		 
		 Double n=Double.parseDouble(str);
		 Double m=Math.sqrt(n);
		 
		 Double m1=Math.ceil(m);
		 int val=m1.intValue();
		 int res=val;
		 if(val==m.intValue())
		 {
			 res=res+1;
		 }
		 System.out.println(m+" avad:"+val);*/
		pair a=new pair();
		a.x=10;
		a.y=15;
		pair b=new pair();
		b.x=100;
		b.y=150;
		System.out.println("a:"+a+" b:"+b);
		swap(a,b);
		System.out.println("a.x:"+a.x+" a.y:"+a.y+" b:"+b.x);
		//LinkedHashMap<K, V>
		String aa="";
		aa.hashCode();
		LinkedHashMap<String,String> val=new LinkedHashMap<String,String> ();
		val.hashCode();
		Object obj;
		testJava tj=new testJava();
		testJava.Person p=tj.new Person();
		p.hashCode();
		

	}
	public static void swap(pair a,pair b)
	{
		System.out.println("a:"+a+" b:"+b);
		pair c;
		c=b;
		b=a;
		a=c;
		System.out.println("adftera a:"+a+" b:"+b);
		System.out.println("inasdi a.x:"+a.x+" a.y:"+a.y+" b:"+b.x);
	}
	
	class Person{
		String name;
		int id;
	}
	

}
 
 

