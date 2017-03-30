package QQDemo;

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
	DatagramSocket ds= new DatagramSocket(10000);
	while(true){
	byte[] bys=new byte[1024];
	DatagramPacket dp =new DatagramPacket(bys,bys.length);
	ds.receive(dp);
	String s=new String (dp.getData(),0,dp.getLength());
	System.out.println(dp.getAddress().getHostAddress()+" : "+s);
	}
}
}
