package ConceptImplementation;

public class MethodOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodOverloading methodOverloading=new MethodOverloading();
		
		System.out.println(methodOverloading.add(10.0, 5));
		System.out.println(methodOverloading.add(10, 5));
		System.out.println(methodOverloading.add(10, 7));
		System.out.println(methodOverloading.add(10, 5,8));

	}
	
	int add(int a,int b) {
		return a+b;
	}
	int add(int a,int b,int c) {
		return a+b;
	}
	int add(int a,Integer b) {
		return a+b;
	}
	int add(Double a,Integer b) {
		return a.intValue()+b;
	}

}
