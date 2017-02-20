
public class exceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int arr[]={2,5,3,4,10};
			int x=arr[6];
			System.out.println("in try :"+x);
		}
		catch (ArrayIndexOutOfBoundsException exc)
		{
			System.out.println("in catch");
		}
		System.out.println("after");
		

	}

}
