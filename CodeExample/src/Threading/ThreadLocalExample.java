package Threading;

public class ThreadLocalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLocal<String> tl =new ThreadLocal<String>();
		tl.set("example 1");
		Mythreand t1=new Mythreand(tl, "first  Thread");
		Mythreand t2=new Mythreand(tl, "second  Thread");
		t1.start();
		t2.start();
		//
		
		

	}

}

class Mythreand extends Thread{
	ThreadLocal<String> tl=null;
	String name="";
	Mythreand(ThreadLocal<String> tl,String name){
		this.tl=tl;
		this.name=name;
	}
	public void run() {
		
		for(int i=0;i<10;i++) {
			String str=tl.get();
			System.out.println("name:"+name+ " str:"+str);
			tl.set(name+ i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
