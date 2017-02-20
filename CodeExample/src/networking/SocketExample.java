package networking;

import java.io.*;
import java.io.OutputStream;
import java.net.*;

//Demonstrate Sockets.
public class SocketExample {
	public static void main(String args[]) throws Exception {
		int c;
		// Create a socket connected to internic.net, port 43.
		Socket s = new Socket("google.com", 43);
		// Obtain input and output streams.
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		// Construct a request string.

		String str = (args.length == 0 ? "osborne.com" : args[0]) + "\n";
		// Convert to bytes.
		byte buf[] = str.getBytes();
		// Send request.
		out.write(buf);
		// Read and display response.
		while ((c = in.read()) != -1) {
			System.out.print((char) c);
		}
		s.close();
	}
}
