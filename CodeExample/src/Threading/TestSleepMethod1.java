package Threading;

class TestSleepMethod1 extends Thread{  
	 public void run(){  
	  for(int i=1;i<5;i++){  
	    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
	    System.out.println(i);  
	    //System.out.println("State:"+);
	  }  
	 }  
	 public static void main(String args[]){  
	  TestSleepMethod1 t1=new TestSleepMethod1();  
	  TestSleepMethod1 t2=new TestSleepMethod1();  
	   
	  t1.start();
	  System.out.println("State:"+t1.getState());
	  t2.start();
	  System.out.println("State:"+t2.getState());
	 }  
}  
