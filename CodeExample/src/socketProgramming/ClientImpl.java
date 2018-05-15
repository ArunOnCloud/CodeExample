package socketProgramming;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientImpl {
	
	Socket socket=null;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stubent
		ClientImpl clientImpl=new ClientImpl();
		clientImpl.start();

	}
	public void start() throws Exception{
		socket=new Socket("127.0.0.1", 55000);
		
		DataOutputStream out=new DataOutputStream(socket.getOutputStream());
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line="";
		
		while(!line.equalsIgnoreCase("end")) {
			
			line=br.readLine();
			out.writeUTF(line);
			
		}
		
		socket.close();
		
	
		
		
		
	}

}
