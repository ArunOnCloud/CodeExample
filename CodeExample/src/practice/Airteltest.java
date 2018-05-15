package practice;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class Airteltest {
    Database db=new Database();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Airteltest airteltest=new Airteltest();
		Scanner sc=new Scanner(System.in);
		while(true){
			prompt();
		  int op=sc.nextInt();
		  
		  if(op == 5) {
			  break;
		  }else if(op == 1) {
			  System.out.println("Enter set key then score:");
			  int set=sc.nextInt();
			  int key=sc.nextInt();
			  int val=sc.nextInt();
			  airteltest.db.addScore(set,key, val);
		  }else if(op == 2) {
			  System.out.println("Enter set and key to remove:");
			  int set=sc.nextInt();
			  int key=sc.nextInt();
			  airteltest.db.removeKey(set,key);
		  }else if(op == 3) {
			  /*System.out.println("Enter key to remove:");
			  int key=sc.nextInt();
			  airteltest.db.removeKey(key);*/
			  System.out.println("Enter set ");
			  int set=sc.nextInt();
			  System.out.println("size is :"+airteltest.db.getSize(set));
		  }else if(op == 4) {
			  System.out.println("Enter set and key to get score:");
			  int set=sc.nextInt();
			  int key=sc.nextInt();			  
			  System.out.println(airteltest.db.getKeyValue(set,key));
			  
		  }else if(op == 6) {
			  System.out.println("Enter number of key and then keys");
			  int n=sc.nextInt();
			  int[] arr=new int[n];
			  for(int i=0;i<n;i++) {
				 arr[i]=sc.nextInt();
			  }
			  System.out.println("Enter score range (two integer)");
			  int l=sc.nextInt();
			  int h=sc.nextInt();
			  airteltest.db.getRange(arr, l, h);
			  
			  //System.out.println(airteltest.db.getKeyValue(key));
			  
		  }
		  
			
			
		}
		

	}
	static void prompt() {
		System.out.println("Enter Number for  Operation:");
		System.out.println("1 for add score:");
		System.out.println("2 for removeKey");
		System.out.println("3 for size:");
		System.out.println("4 for getting score:");
		System.out.println("5 disconnecting");
		System.out.println("6 getting range");
	}

}

class Database{
	Map<Integer,Map<Integer,Integer>> map=null;
	Database(){
		map=new TreeMap<>();
	   //map=Collections.synchronizedMap(map);
	}
	public void addScore(Integer set,Integer key,Integer score) {
		if(map.containsKey(set)) {
			map.get(set).put(key, score);
		}else {
			map.put(set, new TreeMap<>());
			map.get(set).put(key, score);
		}
		
	}
	public void removeKey(Integer set,Integer key) {
		if(map.containsKey(set)) {
			map.get(set).remove(key);
		}
		
	}
	public int getSize(Integer set) {
		if(map.containsKey(set)) {
			return map.get(set).size();
		}else {
			return 0;
		}
		
	}
	public int getKeyValue(Integer set,Integer key) {
		if(map.containsKey(set)) {
			if(map.get(set).containsKey(key)) {
				return map.get(set).get(key);
				
			}else {
				return 0;
			}
			
		}else {
			return 0;
		}
	}
	public void getRange(int[] arr,int l,int r) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			System.out.println("set id:"+arr[i]);
			Map<Integer,Integer> set=map.get(arr[i]);
			if(set!=null) {
				for(Map.Entry<Integer,Integer> entry: set.entrySet()) {
					if(entry.getValue() >= l && entry.getValue() <=r) {
						System.out.println("key:"+entry.getKey()+ " score:"+entry.getValue());
					}
				}
			}
		}
		
	}
}
