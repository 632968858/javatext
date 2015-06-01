package nettest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class PictureServer {
	public static void main (String[] argv) throws IOException {
		// TODO Auto-generated method stub
		//创建socket服务
		ServerSocket ss =new ServerSocket(10000);
		Socket s =ss.accept();
		
		//接收图片字节流
		BufferedInputStream bi =new BufferedInputStream(s.getInputStream());
		//输出到文件中
		BufferedOutputStream bo=new BufferedOutputStream(new FileOutputStream("mn.png"));
		
		byte [] bys =new byte[1024];
		int len=0;
		while((len=bi.read(bys))!=-1){
			bo.write(bys,0,len);
			bo.flush();
		}
		bo.close();
		//反馈
		
		BufferedOutputStream bo2=new BufferedOutputStream(s.getOutputStream());
		bo2.write("上传完毕".getBytes());
		bo2.flush();
		bo2.close();
		s.close();
		
	}
}
