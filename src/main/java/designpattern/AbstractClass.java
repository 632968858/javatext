package designpattern;
/*模板模式
 * 
 * 
 * */
public abstract class AbstractClass {
	public final void templateMethod(){ //防止子类改变顺序
		primitiveOperation1();
		primitiveOperation2();
		concreteOperation();
		hook();
	}
	public abstract void primitiveOperation1();
	public abstract void primitiveOperation2();
	public final void concreteOperation(){ //共有方法
		//实现
	}
	public void hook(){
		//钩子 ，子类可以覆盖
	}
	
}
