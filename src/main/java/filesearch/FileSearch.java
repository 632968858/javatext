package filesearch;

import java.io.File;

public class FileSearch implements Runnable {

	private String path;
	private String filename;

	public FileSearch(String path, String filename) {
		this.path = path;
		this.filename = filename;
	}

	@Override
	public void run()   {
		File file = new File(path);
		if (file.isDirectory()) {
			try {
				processDirectory(file);

			} catch (InterruptedException e) {
				System.out.printf("%s: has interrupted", Thread.currentThread()
						.getName());
		}
		}

	}

	private void processDirectory(File file) throws InterruptedException {

		File[] list = file.listFiles();
		if (list != null) {
			for (File f : list) {
				if (f.isDirectory()) {
					processDirectory(f);
				} else {
					processFile(f);
				}
			}
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}

	}

	private void processFile(File file) throws InterruptedException {
		if (file.getName().equals(filename)) {
			System.out.printf("%s : %s\n", Thread.currentThread().getName(),
					file.getAbsolutePath());
		}

		if (Thread.interrupted()) {
			throw new InterruptedException();
		}

	}

}
