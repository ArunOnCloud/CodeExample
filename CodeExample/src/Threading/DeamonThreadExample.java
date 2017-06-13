package Threading;

public class DeamonThreadExample extends Thread {
	 public void run(){
		 while(true)
		 {
			 System.out.println(" ==============:");
			 try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	 }
	public static void  main(String args[]){
		try{
			DeamonThreadExample ad=new DeamonThreadExample();
		ad.setDaemon(true);
		ad.start();
		for(int i=0;i<1000;i++)
		{
			System.out.println("=====i:"+i);
		}
		//System.out.println("=====finished");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
