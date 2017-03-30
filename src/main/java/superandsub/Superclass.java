package superandsub;
public class Superclass {
	static {
		System.out.println("superclass");
	}
	public static int i=1; //若添加final,则会在编译阶段通过常量传播优化

}
