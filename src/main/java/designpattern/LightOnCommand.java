package designpattern;
/*命令行模式
 * 
 * 含有撤销操作
 * */
public class LightOnCommand implements Command {
	private Light light;
	public LightOnCommand(Light light) {
		// TODO Auto-generated constructor stub
		this.light=light;
	}
	public void excute(){
		light.on();
	}
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		light.off();
	}
}
