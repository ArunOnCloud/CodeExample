package practice;

class SpaceException extends Exception {
	public SpaceException()
	{
	
	}
	public SpaceException(String message)
	{
	   super(message);
	}
	
	
}


public class CustomException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new NumberFormatException(); 
		
		Integer a=Integer.parseInt("123");

	}

}
