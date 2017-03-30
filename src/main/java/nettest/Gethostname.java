package nettest;
import java.io.IOException;
import java.net.InetAddress;
public class Gethostname {
public static void main(String[] args) throws IOException {
//	String s="219.245.92.38";
	
	InetAddress na= InetAddress.getByName("xiaoyu");
	System.out.println(na.getHostAddress());
}
}
