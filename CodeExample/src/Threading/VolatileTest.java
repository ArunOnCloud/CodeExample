package Threading;

public class VolatileTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n=100000;
		ThreadCustom[] threadCustom=new ThreadCustom[n];
		CustomData customData=new CustomData();
		customData.data=0;
		for(int i=0;i<n;i++ )
		{
			threadCustom[i]=new ThreadCustom(customData, "Thread-"+i+" ");
		}
		for(int i=0;i<n;i++ )
		{
			threadCustom[i].start();
		}
		Thread.sleep(10000l);
		System.out.println("final value:"+ customData.data);

	}

}
class  CustomData{
	public volatile int data;
	
	public synchronized void incrementData() {
		this.data++;
	}
	
}
class ThreadCustom extends Thread{
	CustomData customData=null;
	String name="";
	public ThreadCustom(CustomData customData,String name) {
		this.customData=customData;
		this.name=name;
	}
	public void run() {
		//below synchronized not working
		/*synchronized (this) {
			customData.data++;
			System.out.println(name + " data: "+ customData.data);
		}*/
		
		customData.data++;
		System.out.println(name + " data: "+ customData.data);
		/*customData.incrementData();
		System.out.println(name + " data: "+ customData.data);*/
	}
}
