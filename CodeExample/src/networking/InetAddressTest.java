package networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

class InetAddressTest {
	public static void main(String args[]) throws UnknownHostException {
		InetAddress Address = InetAddress.getLocalHost();
		System.out.println(Address);
		Address = InetAddress.getByName("www.osborne.com");
		System.out.println(Address);
		InetAddress SW[] = InetAddress.getAllByName("www.facebook.com");
		for (int i = 0; i < SW.length; i++)
			System.out.println(SW[i]);
	}
}