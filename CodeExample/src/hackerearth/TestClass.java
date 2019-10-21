package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class TestClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        absInt[] arr=new absInt[N];
        line=br.readLine();
        String[] intArr=line.split(" ");
        for(int i=0;i<N;i++)
        {
        	arr[i]=new absInt();
        	arr[i].data=Integer.parseInt(intArr[i]);
        }
        Arrays.sort(arr);
        for(int i=0;i<N;i++)
        {
        	System.out.print(arr[i].data+" ");
        }
        
         
        

	}

}
class absInt implements Comparable<absInt>{
	public int data;
	public int compareTo(absInt value) {
		int a,b;
		if(value.data<0)
			{
			  b=-value.data;
			}else
			{
				b=value.data;
			}
		
		if(this.data<0)
		{
			a=-this.data;
		}else
		{
			a=this.data;
		}
		return a-b;

		//int compareQuantity = ((Fruit) compareFruit).getQuantity();

		//ascending order
		//return this.quantity - compareQuantity;

		//descending order
		//return compareQuantity - this.quantity;

	}
	
}
