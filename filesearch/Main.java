package filesearch;

public class Main {
	public static void main(String[] args) {
		FileSearch fileSearch = new FileSearch("/", "hello");
		
		Thread t =new Thread(fileSearch);
		
		t.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t.interrupt();
	}
}
