package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PlusPlus {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        String[] sarr=line.split(" ");
	        int r=Integer.parseInt(sarr[0]);
	        int c=Integer.parseInt(sarr[1]);
	        int[][] arr=new int[r][c];
	        for(int i=0;i<r;i++){
	        	line=br.readLine();
	        	sarr=line.split(" ");
	        	int[] a=new int[c];
	        	for(int j=0;j<c;j++){
	        		a[j]=Integer.parseInt(sarr[j]);
	        	}
	        	arr[i]=a;
	        }
	        int ans=fun(arr,r,c);
	        System.out.println(ans);

	}
   static int fun(int[][] arr,int r,int c){
	   int maxVal=Integer.MIN_VALUE;
	   if(r<=0 || c<=0){
		   return 0;
	   }
	   for(int i=0;i<r-1;i++){
		   for(int j=0;j<c-1;j++){
			   for(int i1=i;i1 <r;i1++){
				   for(int j1=j;j1<c;j1++){
					   if(isOverlappping(i1, j1, i, j)){
						   continue;
					   }
					   int a1=util(arr,i,j,i1,j1,r,c);
					   int a2=util(arr,i+1,j,i1+1,j1,r,c);
					   int a3=util(arr,i-1,j,i1-1,j1,r,c);
					   int a4=util(arr,i,j+1,i1,j1+1,r,c);
					   int a5=util(arr,i,j-1,i1,j1-1,r,c);
					   if(a1<0 || a2<0 || a3 <0 ||a4<0 || a5<0){
						   continue;
					   }
					   int sum=a1+a2+a3+a4+a5;
					   if(sum>maxVal){
						   maxVal=sum;
					   }
					   
					   
					   
				   }
			   }
		   }
	   }
	   
	   
	   return maxVal;
   }
   static boolean isOverlappping(int i1,int j1,int i2,int j2){
	  Set<Pair> set1=new TreeSet<>((i,j) ->{   if(i.x==j.x && i.y==j.y){
		  return 0;
		  }else if(i.x == j.x){
			  return i.y-j.y;
			  }else{
				  return i.x-j.x;
				  
				  }});
		 
	 
	 Set<Pair> set2=new TreeSet<>((i,j) ->{   if(i.x==j.x && i.y==j.y){
		  return 0;
		  }else if(i.x == j.x){
			  return i.y-j.y;
			  }else{
				  return i.x-j.x;
				  
				  }});
			  
	  set1.add(new Pair(i1,j1));
	  set1.add(new Pair(i1+1,j1));
	  set1.add(new Pair(i1-1,j1));
	  set1.add(new Pair(i1,j1+1));
	  set1.add(new Pair(i1,j1-1));
	  set2.add(new Pair(i2,j2));
	  set2.add(new Pair(i2+1,j2));
	  set2.add(new Pair(i2-1,j2));
	  set2.add(new Pair(i2,j2+1));
	  set2.add(new Pair(i2,j2-1));
	  for(Pair p:set1){
		  for(Pair p1 :set2){
			  if(p.x == p1.x && p.y ==p1.y){
				  return true;
			  }
		  }
	  }
	  
	  return false;
	   
   }
   static class Pair{
	   int x;
	   int y;
	   Pair(int x,int y){
		   this.x=x;
		   this.y=y;
	   }
   }
   
   static int util(int[][] arr,int i1,int j1,int i2,int j2,int r,int c){
	   if(i1 == i2 && j1== j2){
		   return Integer.MIN_VALUE;
		   
	   }else if(i1 <0 || i1<0 || j1<0 || j2 <0 || i1>=r || i2>=r || j1>=c || j2>=c){
		   return Integer.MIN_VALUE;
	   }else{
		   return arr[i1][j1]* arr[i2][j2];
	   }
   }

}
