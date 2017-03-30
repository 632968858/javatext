package QQDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ThreadSender implements Runnable {
	private DatagramSocket ds;
	
	public ThreadSender(DatagramSocket ds){
		this.ds =ds;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String line =null;
		try {
			while((line=br.readLine())!=null){
				if("886".equals(line)){
					break;
					}
				
				else{
					byte [] bys=line.getBytes();
					DatagramPacket dp=new DatagramPacket(bys,bys.length,InetAddress.getByName("219.245.92.38"),10240);
					ds.send(dp);
					}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ds.close();
	}

}
