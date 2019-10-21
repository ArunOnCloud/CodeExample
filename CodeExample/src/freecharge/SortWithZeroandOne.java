package freecharge;

public class SortWithZeroandOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {0,1,1};
		//111111100000001111
		int []arr2 = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1};
		sort(arr,0,arr.length  -1);
		printArray(arr);
		
		
		

	}
	public static void printArray(int arr[]) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
	
	}
	
	public static void sort(int arr[], int left, int right) {

		int i = left;
		int j = right;

		while(i<j ) {

			while(i<=right && arr[i]==0 ) {
				i++;
			} 

			while(j>=left && arr[j]==1  ) {
				j--;
			}

			if(i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}

		}


	}

}
