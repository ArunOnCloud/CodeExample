import java.io.*;
public class inputFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s="C:Users\arun\Desktop\office";
		String s="C:/myapp/test.txt";
		//File file = new File("C:/robots.txt");
		//FileInputStream fis = null;
		FileInputStream fin;
		try{
			 fin=new FileInputStream(s);
			
		/*}catch(IOException exe)
		{
			System.out.println("Error in finding the file");
		}*/
		try{
			int i=fin.read();
			while(i!=-1)
			{
				System.out.print((char)i);
				i=fin.read();
			}
		 }catch(IOException e)
		  {
			
		  }
		/*} catch(IOException exe)
		{
			System.out.println("Error in finding the file");
		}
		*/
		try{
		   fin.close();
		}catch(IOException e)
		{
			System.out.println("Error occred");
		}
		}catch(IOException exe)
		{
			System.out.println("Error in finding the file");
		}
		System.out.println("\nfile end");

	}

}
