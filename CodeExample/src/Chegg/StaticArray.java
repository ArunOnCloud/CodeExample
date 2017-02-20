package Chegg;

public class StaticArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=7;// size of the array
		int[] arr={1,6,7,32,45,32,21};
		int sum=0;
		//loop for summing the double the value of each element
		for(int i=0;i<size;i++)
		{
			sum=sum+(2*arr[i]);
		}
		//printing sum variable
		System.out.println("Sum:"+sum);
		
		
		
		
		

	}

}
