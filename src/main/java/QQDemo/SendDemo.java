package QQDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		DatagramSocket ds =new DatagramSocket();
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String line =null;
		while((line=br.readLine())!=null){
			//byte [] bys="hello".getBytes();
			if(line.equals("886")){
				break;
			}else{
			
			byte[] bys =line.getBytes();
			DatagramPacket dp =new DatagramPacket(bys,bys.length,InetAddress.getByName("219.245.92.255"),10000);
			ds.send(dp);
			}
		}
		ds.close();
		
	}
}
