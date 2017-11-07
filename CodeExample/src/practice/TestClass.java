package practice;

/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
class A{
   public  A() {
        System.out.println(" A cons called");
    }
    public void print(){
         System.out.println(" A  print called");
    }
}
class B extends A{
   public  B() {
        System.out.println(" B cons called");
    }
    public void print(){
         System.out.println(" B  print called");
         super.print();
         //print();
    }
}
public class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */

        System.out.println("Hello World!");
        
      /*  A a=new A();
        a.print();
        
        a=new B();
        a.print();
        */
        
        int val=1;
        System.out.println(val);
        while(val <1000)
        {
        	//val <<=1;
        	
        	val = val << 1;
        }
        System.out.println(val);

        
        
    }
    
}
