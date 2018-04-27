package practice;

public class VarArgsApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun(3,3,3,3,9,23,2);

	}
	
	static void fun(int... arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]+ " ");
		}
	}

}
