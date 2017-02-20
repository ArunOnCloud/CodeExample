package practice;

public class AnnonymousClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TestingInterface testingInterface=new TestingInterface() {
			
			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println(" arun kumar tasdfa");
				
			}
		};
		testingInterface.print();
	}
	
	
 

}
 interface TestingInterface{
	 public void print();
 }
