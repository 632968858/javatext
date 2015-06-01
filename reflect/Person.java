package reflect;

public class Person {
	private String name;
	private int age;
	private String address;
	public Person(){
		
	}
	private Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public Person(String name,int age,String address){
		this.name=name;
		this.age=age;
		this.address=address;
	}
	private void show(){
		System.out.println("show");
	}
	public String getname(String name){
		return name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address
				+ "]";
	}

	
}
