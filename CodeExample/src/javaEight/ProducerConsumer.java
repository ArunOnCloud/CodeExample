package javaEight;

public class ProducerConsumer {
	int mango=0;
	
	public synchronized void produce()
	{
		System.out.println("=============Produced mango:"+2);
	    mango+=2;
	    
	    System.out.println("===========total mango:"+mango);
	    if(mango>=4)
	    notify();
	}
	public synchronized void consume()
	{
		if(mango<4)
		{
			try {
				System.out.println("============waiting mango to be produced=========");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("==============consuming mango:=============");
		mango-=4;
		System.out.println("remain mango:"+mango);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProducerConsumer producerConsumer=new ProducerConsumer();
		
		new Thread(){
			public void run()
			{
				for(int i=0;i<Integer.MAX_VALUE;i++)
				{
					producerConsumer.consume();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread(){
			public void run()
			{
				for(int i=0;i<Integer.MAX_VALUE;i++)
				{
					producerConsumer.produce();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		
		

	}

}
