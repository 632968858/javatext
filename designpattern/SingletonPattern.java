package designpattern;

public class SingletonPattern {
	private volatile static SingletonPattern uniqueInstance;
	private SingletonPattern(){}
	public SingletonPattern getInstance(){
		if(uniqueInstance==null)
			synchronized(SingletonPattern.class){
			if(uniqueInstance==null)
				uniqueInstance=	new SingletonPattern();
		}
			
		return uniqueInstance;
	}
}
