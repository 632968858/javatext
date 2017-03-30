package Pattern;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 1从文件中读取字符串
 * 2解析字符串为字符串数组
 * 3int 整形
 * 4,排序
 * 5 链接
 * 6输出字符串
 * 
 * 
 */
public class PatternSort {
	public static void main(String[] args)throws IOException {
	
		BufferedReader br =new BufferedReader(new FileReader("unsort.txt"));
		BufferedWriter bw =new BufferedWriter(new FileWriter("sort.txt",true));
		String line=null;
		while((line=br.readLine())!=null){
			String [] out =line.split(" +");   //regex 为多个空格相加
			int [] outi =new int [out.length];
			for(int i=0;i<out.length;i++){
				outi[i]=Integer.parseInt(out[i]);
			}
			Arrays.sort(outi);
			StringBuilder sb=new StringBuilder();
			for(int i:outi){
				sb.append(i).append(" ");
			}
			String so=sb.toString();
			bw.write(so.trim());
			bw.newLine();
			bw.flush();
			System.out.println(so.trim());
		}
		bw.close();
		br.close();
	}
}
