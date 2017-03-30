package QQDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ThreadReceived implements Runnable {
	private DatagramSocket ds;
	public ThreadReceived(DatagramSocket ds) {
		// TODO Auto-generated constructor stub
		this.ds=ds;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			byte [] bys =new byte[1024];
			DatagramPacket dp =new DatagramPacket(bys,bys.length);
			try {
				ds.receive(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(dp.getAddress().getHostAddress()+": "+new String (dp.getData(),0,dp.getLength()));
		}
	}
}
