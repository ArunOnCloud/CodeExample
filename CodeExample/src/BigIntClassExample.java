import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class BigIntClassExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        String[] arr=line.trim().split(" ");
        BigInteger a,b,c;
        a=new BigInteger(arr[0]);
        b=new BigInteger(arr[1]);
        c=null;
        //c=new BigInteger(arr[2]);
        //c=a.add(b);
        int n=Integer.parseInt(arr[2]);
        int A,B,C;
        
        //System.out.println("a:"+a+" b:"+b+" a+b:"+c);
        for(int i=2;i<n;i++){
        	c=a.add(b.multiply(b));
        	a=b;
        	b=c;
        }
        System.out.println(c);
	}

}
