package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("reflect.Person");
		System.out.println("反射构造函数-----------------------------------------------------");
		
		//反射 可以访问所有构造函数
		Constructor[] cons=c.getDeclaredConstructors();
		for(Constructor c2:cons)
		{
			System.out.println(c2);
		}
		
		
		//反射 可以访问私有构造函数
		Constructor con=c.getDeclaredConstructor(String.class,int.class);
		con.setAccessible(true);
		Object o=con.newInstance("xiaoming",10);
		System.out.println(o);
		
		
		System.out.println("反射构造函数------------------------getConstructors-----------------------------");
		Constructor[] conss=c.getConstructors();
		for(Constructor c3:conss)
		{
			System.out.println(c3);
		}
		
		
		
		
		System.out.println("反射成员变量-----------------------------------------------------");
		
		//反射获取所有成员变量
		Field [] fields=c.getDeclaredFields();
		for(Field f:fields)
		{
			System.out.println(f);
		}
		//获取某个成员变量的对象
		Field addressField =c.getDeclaredField("address");
		Constructor cf=c.getConstructor();
		Object o1=cf.newInstance();
		
		//暴力设置权限
		addressField.setAccessible(true); //私有成员变量
		
		addressField.set(o1, "北京");  //给新创建的对象o1的成员变量address的对象，赋值为“北京”
		
		Field age =c.getDeclaredField("age");
		age.setAccessible(true);
		age.set(o1, 12);
		
		Field name =c.getDeclaredField("name");
		name.setAccessible(true);
		name.set(o1, "xiaomi");
		
		
		
		System.out.println(o1);
		
		
		System.out.println("反射获取公有方法-----------------------------------------------------");
		
		//反射获取方法
		/*
		 * 	Method[] ms=c.getMethods()//返回包括父类的所有共有方法
		 * 	
		 */
	
		
		Method[] ms=c.getMethods();//返回包括父类的所有方法
		for(Method m :ms){
			System.out.println(m);
		}
		System.out.println("反射获取本类方法-----------------------------------------------------");
		
		Method[] msd=c.getDeclaredMethods();//返回包括私有的所有方法
		for(Method m :msd){
			System.out.println(m);
		}
		Method mshow =c.getDeclaredMethod("show");
		
		Constructor c3 =c.getDeclaredConstructor();
		Object o3=c3.newInstance();
		
		mshow.setAccessible(true);
		mshow.invoke(o3);
		
		//有参的方法调用
		Method mgetname =c.getDeclaredMethod("getname",String.class);
		mgetname.setAccessible(true);
		Object getname=mgetname.invoke(o3, "getnameparams");
		System.out.println(getname);
		
		
	}
}
