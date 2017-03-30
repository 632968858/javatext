package range;

public class RecordNode {
	private Element element ;//值域
	private KeyType key ;//关键字
	public RecordNode(KeyType key){
		this.key=key;
	}
	public RecordNode(KeyType key, Element element){
		this.key=key;
		this.element=element;
	}
	public Element getElement(){
		return element;
	}
	public void setElement(Element element){
		this.element=element;
	}
	public KeyType getKey(){
		return key;
	}
	public void setKey(KeyType key){
		this.key=key;
	}
	public void display(){
		key.display();
		element.display();
	}
}
