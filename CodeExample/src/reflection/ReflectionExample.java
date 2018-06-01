package reflection;

public class ReflectionExample {

	public static void main(String[] args) throws Exception, IllegalAccessException {
		// TODO Auto-generated method stub
		Class c=Simple.class;
		Simple simple=(Simple)c.newInstance();
		simple.print();
		Class re=ReflectionExample.class;
		Class ce=ReflectionExample.class;
		if(re == ce) {
			System.out.println("arun");
			System.out.println(re);
		}else {
			
			System.out.println("arun: asddf");
		}

	}

}

class Simple{
	
	public void print(){
		System.out.println("run time simple called");
	}
}
