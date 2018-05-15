package socketProgramming;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketImpl {
	
	Socket socket=null;
	ServerSocket server=null;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocketImpl serverSocketImpl=new ServerSocketImpl();
		serverSocketImpl.startServer();
	}
	public void startServer() throws Exception {
		server=new ServerSocket(55000);
		System.out.println(" Server started");
		socket=server.accept();
		
		DataInputStream input=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		
		//DataOutputStream out=new DataOutputStream(System.out);
		String line="";
		while(!line.equals("end")) {
			
			line=input.readUTF();
			System.out.println(line);
		}
		input.close();
		socket.close();
		
		
	}

}
