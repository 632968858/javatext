package QQDemo;

import java.io.IOException;
import java.net.DatagramSocket;
public class Threadqq {
	public static void main(String[] args) throws IOException {
		DatagramSocket sendds=new DatagramSocket();
		DatagramSocket receiveds =new DatagramSocket(10240);
		
		ThreadSender ts =new ThreadSender(sendds);
		ThreadReceived dr =new ThreadReceived(receiveds);
		
		new Thread(ts).start();
		new Thread(dr).start();		
		
	}
}
