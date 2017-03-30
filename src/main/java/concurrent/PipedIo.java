package concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable{
	private Random rand =new Random(47);
	private PipedWriter out= new PipedWriter(); ////////////////////
	public PipedWriter getPipedWriter(){
		return out;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			for(char c='A';c<'Z';c++)
			{
				try {
					out.write(c);
					TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		}
	}
}
class Recevier implements Runnable{
	private PipedReader in;
	public Recevier(Sender sender) throws IOException{
		in=new PipedReader(sender.getPipedWriter());///////////////////////
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				System.out.println("reader:"+(char)in.read()+",");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
public class PipedIo {
public static void main(String[] args) throws IOException, InterruptedException {
	Sender sender=new Sender();
	Recevier recevier =new Recevier(sender);
	ExecutorService exec =Executors.newCachedThreadPool();
	exec.execute(sender);
	exec.execute(recevier);
	TimeUnit.SECONDS.sleep(4);
	exec.shutdownNow();
}
}

