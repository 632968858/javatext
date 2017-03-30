package superandsub;

public class NotInit {
public static void main(String[] args) { //会加载子类但不会初始化
	System.out.println(Subclass.i);
}
}
