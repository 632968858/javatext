package range;

public class Element {
	private String data;
	public Element(){}
	public Element(String data){this.data=data;}
	public void setData(String data){this.data=data;}
	public String getData(){return data;}
	public void display(){
		System.out.println(data);
	}
}
