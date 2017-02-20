package Chegg;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=7;// size of the array
		size=7+2;// adding two more element
		int[] arr={1,6,7,32,45,32,21,66,45};
		int sum1=0;
		//loop for summing the double the value of each element
		int sum2=0;
		for(int i=0;i<size;i++)
		{
			//summing all element above 70
			if(arr[i]>70)
			{
				sum1=sum1+arr[i];
			}
			//summing all element below 70 in another variable
			if(arr[2]<70)
			{
				sum2=sum2+arr[i];
			}
			
		}
		//printing sum1 and sum2  variable
		System.out.println("Sum1:"+sum1+" sum2:"+sum2);

	}

}
