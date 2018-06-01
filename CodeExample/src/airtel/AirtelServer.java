package airtel;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;


public class AirtelServer {
	    private Socket          socket   = null;
	    private ServerSocket    server   = null;
	    private DataInputStream in       =  null;
	    
	    
	    public AirtelServer(int port)
	    {
	        // starts server and waits for a connection
	        try
	        {
	            server = new ServerSocket(port);
	            System.out.println("Server started");
	 
	            System.out.println("Waiting for a client ...");
	 
	            socket = server.accept();
	            System.out.println("Client accepted");
	 
	            // takes input from the client socket
	            in = new DataInputStream(
	                new BufferedInputStream(socket.getInputStream()));
	 
	            String line = "";
	 
	            // reads message from client until "Over" is sent
	            while (!line.equals("Over"))
	            {
	                try
	                {
	                    line = in.readUTF();
	                    System.out.println(line);
	 
	                }
	                catch(IOException i)
	                {
	                    System.out.println(i);
	                }
	            }
	            System.out.println("Closing connection");
	 
	            // close connection
	            socket.close();
	            in.close();
	        }
	        catch(IOException i)
	        {
	            System.out.println(i);
	        }
	    }
	 
	    public static void main(String args[])
	    {
	        AirtelServer server = new AirtelServer(5000);
	    }

	
}
class Database{
	Map<Integer,Integer> map=null;
	Database(){
		map=new TreeMap<>();
	   map=Collections.synchronizedMap(map);
	}
	public void addScore(Integer key,Integer score) {
		map.put(key, score);
	}
	public void removeKey(Integer key) {
		map.remove(key);
	}
	public int getSize() {
		return map.size();
	}
	public int getKeyValue(Integer key) {
		if(map.containsKey(key)) {
			return map.get(key);
		}else {
			return 0;
		}
	}
}
