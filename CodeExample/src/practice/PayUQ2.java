package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PayUQ2 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/ArunAdmin/Desktop/payu/input2.csv"));
		String line=br.readLine();
		if(!(line !=null && line.length()>0)){
			System.out.println("provide input in file");
			br.close();
			return;
		}
		int n=Integer.parseInt(line.trim());
		int[][] arr=new int[n][n];
		line=br.readLine();
		String[] sarr=line.split(" ");
		int ind=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				arr[i][j]=Integer.parseInt(sarr[ind]);
				ind++;
			}
		}
		line=br.readLine();
		int t=Integer.parseInt(line);
		print(arr, n);
		util(arr,n,t);
		print(arr,n);
		
		

	}
	static void util(int[][] arr,int n,int t){
		
		for(int i=0;i<n/2;i++){
			utilTemp(arr, i, n-1-i, t);
		}
		
		
	}
	static void utilTemp(int[][] arr, int is,int ie,int t){
		int n=ie-is+1;
		
		List<Integer> list=new ArrayList<>();
		for(int i=is;i<=ie;i++){
			list.add(arr[is][i]);
		}
		for(int i=is+1;i<=ie;i++){
			list.add(arr[i][ie]);
		}
		for(int i=ie-1;i>=is;i--){
			list.add(arr[ie][i]);
		}
		for(int i=ie-1;i>is;i--){
			list.add(arr[i][is]);
		}
		
		int listSize=list.size();
		List<Integer> al=new ArrayList<>(listSize);
		for(int i=0;i<list.size();i++){
			int t1=i-t;
			while(t1<0){
				t1+=listSize;
			}
			int ind=t1%list.size();
			int temp=list.get(ind);
			al.add(temp);
		}
		
		int ind=0;
		for(int i=is;i<=ie;i++){
		
			arr[is][i]=al.get(ind);
			ind++;
			
		}
		for(int i=is+1;i<=ie;i++){
			
			arr[i][ie]=al.get(ind);
			ind++;
			
		}
		for(int i=ie-1;i>=is;i--){
			
			arr[ie][i]=al.get(ind);
			ind++;
		}
		for(int i=ie-1;i>is;i--){
			
			arr[i][is]=al.get(ind);
			ind++;
		}
		
	}
	static void print(int[][] arr,int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
