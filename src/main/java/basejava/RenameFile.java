package basejava;

import java.io.File;

public class RenameFile {
	public static void main(String[] args) {
		String filepath ="/home/xiaoyu/下载/华为java笔试题大全.docx";
		File file =new File(filepath);
		if(file.exists()){
			file.renameTo(new File("/home/xiaoyu/下载/java笔.docx"));
		}
		
				
		
	}
}
