package designpattern;
/*命令行模式
 * 
 * 含有撤销操作
 * */
public interface Command {
	public void excute();
	public void undo();////撤销操作
}
