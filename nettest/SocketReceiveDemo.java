package nettest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * tcp 服务端
 * 
 */
public class SocketReceiveDemo {
public static void main(String[] args) throws IOException {
	ServerSocket ss =new ServerSocket(10240);
	Socket s =ss.accept();   ///阻塞
	/*InputStream is =s.getInputStream();
	byte [] b =new byte[1024];
	int l=is.read(b);
	System.out.println(new String (b,0,l));*///输出到控制台没有进行包装
	BufferedReader br =new BufferedReader(new InputStreamReader(s.getInputStream()));//包装为字符流
	BufferedWriter bw =new BufferedWriter(new FileWriter("tcpout.txt",true));
	
	String line =null;
	while((line=br.readLine())!=null){
		System.out.println(line);//控制台显示
		bw.write(line);  //写入文件
		bw.newLine();
		bw.flush();
	}
	bw.close();
	
	//反馈
	BufferedWriter bfb =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	bfb.write("传输完毕");
	bfb.newLine();
	bfb.flush();
	bfb.close();
	
	
	s.close();
	
}
}
