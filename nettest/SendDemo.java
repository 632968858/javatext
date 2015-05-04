package nettest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/*
 * udp发送数据
 * 1、创建socket
 * 2、创建数据，并打包
 * 3、调用socket发送
 * 4、释放
 * 
 * 
 */
public class SendDemo {
	public static void main(String[] args) throws IOException {
	/*	DatagramSocket ds =new DatagramSocket();
		byte[] bys = "hello ".getBytes();
		int length =bys.length;
		InetAddress address =InetAddress.getByName("219.245.92.38");
		int port =10000; 
		DatagramPacket dp =new DatagramPacket(bys,length,address,port);
		ds.send(dp);
		ds.close();*/
		DatagramSocket ds =new DatagramSocket();
		byte [] bys="hello".getBytes();
		DatagramPacket dp =new DatagramPacket(bys,bys.length,InetAddress.getByName("219.245.92.38"),10000);
		ds.send(dp);
		ds.close();
		
	}
}
