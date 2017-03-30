package nettest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class PictureClint {
	public static void main(String[] args) throws IOException {
		//socket
		Socket s=new Socket("219.245.92.38",10000);
		
		//创建数据
		BufferedInputStream bi= new BufferedInputStream(new FileInputStream("hello.png"));
		BufferedOutputStream bo= new BufferedOutputStream(s.getOutputStream());
		
		//发送
		byte[] bys =new byte[1024];
		int len=0;
		
		while((len=bi.read(bys))!=-1){
			bo.write(bys, 0, len);
			bo.flush();
		}
		s.shutdownOutput();
		//接受反馈
		BufferedInputStream bi2= new BufferedInputStream(s.getInputStream());
		byte[] bys2 =new byte[1024];
		int len2=0;
		len2=bi2.read(bys2);
		System.out.println(new String (bys2,0,len2));

		bi.close();
		s.close();
		

		
		
		
	}
}
