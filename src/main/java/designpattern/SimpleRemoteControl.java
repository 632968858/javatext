package designpattern;
/*命令行模式
 * 
 * 含有撤销操作
 * */
public class SimpleRemoteControl {
	private Command command;
	public SimpleRemoteControl() {
	}
	public void setCommand(Command command){
		this.command=command;
	}
	public void onButton(){
		command.excute();
	}
	public void undoButton(){
		command.undo();
	}
	public static void main(String[] args) {
		SimpleRemoteControl src =new SimpleRemoteControl();
		Light light =new Light();
		LightOnCommand loc =new LightOnCommand(light);
		src.setCommand(loc);
		src.onButton();
		src.undoButton();
	}
}
