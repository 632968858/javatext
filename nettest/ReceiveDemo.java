package nettest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * udp接收数据
 * 1、创建socket,datagramsocket
 * 2、创建接收包裹datagrampacket
 * 3、接受数据
 * 4、解析数据
 * 
 */
public class ReceiveDemo {
public static void main(String[] args) throws IOException {
	/*DatagramSocket ds =new DatagramSocket(10000);
	byte[] bys =new byte[1024];
	int length=bys.length;
	DatagramPacket dp =new DatagramPacket(bys,length);
	ds.receive(dp);
	InetAddress address=dp.getAddress();
	byte[] bys2=dp.getData();
	String s =new String(bys2,0,dp.getLength());
	System.out.println(address.getHostAddress()+" 发送 "+s);*/
	DatagramSocket ds= new DatagramSocket(10000);
	byte[] bys=new byte[1024];
	DatagramPacket dp =new DatagramPacket(bys,bys.length);
	ds.receive(dp);
	String s=new String (dp.getData(),0,dp.getLength());
	System.out.println(dp.getAddress().getHostAddress()+" : "+s);
	
}
}
