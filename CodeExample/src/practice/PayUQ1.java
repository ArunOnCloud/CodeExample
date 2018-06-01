package practice;

import java.util.Scanner;

public class PayUQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		fun(n);

	}
	static void fun(int n){
		if(n<=0){
			return;
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				System.out.print(" ");
			}
			for(int j=i;j<n;j++){
				System.out.print("* ");
			}
			for(int j=0;j<i;j++){
				System.out.print(" ");
			}
			for(int j=0;j<i;j++){
				System.out.print(" ");
			}
			for(int j=i;j<n;j++){
				System.out.print("* ");
			}
			System.out.println();
		}
		
		
	}

}
