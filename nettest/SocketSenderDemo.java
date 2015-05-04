package nettest;
/*
 * 
 * tcp clint端
 */
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class SocketSenderDemo {
	public static void main(String[] args) throws IOException {
		Socket s =new Socket("219.245.92.38",10240);
	/*	OutputStream os=s.getOutputStream();
		os.write("hello tcp".getBytes());*/
	
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); //包装键盘输入
		
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//包装输出字节流为字符流
		
		BufferedWriter bf =new BufferedWriter(new FileWriter("tcpoutr.txt",true));//包装输出字节流为字符流
		
		BufferedReader file=new BufferedReader(new FileReader("tcpoutr.txt")); //文件为输入流
			
		String line =null;
		
		while((line=br.readLine())!=null){
			if("886".equals(line)){
				break;
			}
			bf.write(line);
			bf.newLine();//分割新行   \n
			bf.flush();
		}
		bf.close();
		
		
		while((line=file.readLine())!=null){
			bw.write(line);
			bw.newLine();//分割新行   \n
			bw.flush();
		}
		file.close();
		s.close();
	}
}
