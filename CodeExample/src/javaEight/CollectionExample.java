package javaEight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create vector object 
		   List<String> list = new ArrayList<String>();
		      
		   // populate the list
		   list.add("1");
		   list.add("2");
		   list.add("3");
		   list.add("4");
		   list.add("5");
		   
		   List<String> li = new ArrayList<String>();
		      
		   // populate the list
		   li.add("1");
		   li.add("2");
		   li.add("3");
		   li.add("4");
		   li.add("5");
		   System.out.println("---------------unsynchronized------------------");
		   Thread thread1=new Thread(){
			   public void run(){
				   for(int i=0;i<list.size();i++)
				   {
					   System.out.println(list.get(i));
					   try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   }
			   }
		   };
		   Thread thread2= new Thread(){
			   public void run(){
				   for(int i=0;i<li.size();i++)
				   {
					   System.out.println(li.get(i));
					   try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   }
			   }
		   };
//		   thread1.run();
//		   thread2.run();
		   thread1.start();
		   thread2.start();
		      
		   // create a synchronized list
		   List<String> synlist = Collections.synchronizedList(list);
		   List<String> synli = Collections.synchronizedList(li);
		   new Thread(){
			   public void run(){
				   for(int i=0;i<synlist.size();i++)
				   {
					   System.out.println(synlist.get(i));
					   try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   }
			   }
		   }.start();;
		   new Thread(){
			   public void run(){
				   for(int i=0;i<synli.size();i++)
				   {
					   System.out.println(synli.get(i));
					   try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   }
			   }
		   }.start();;
		     
		   System.out.println("Sunchronized list is :"+synlist);

	}

}
