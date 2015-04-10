package range;

public class KeyType implements Comparable<KeyType> {
	private int key;
	public KeyType(){}
	public KeyType(int key){
		this.key=key;
	}
	public int getKey(){
		return key;
	}
	public void setKey(int key){
		this.key=key;
	}
	public int compareTo(KeyType key){
		return (this.key>key.getKey())?1:((this.key<key.getKey())?-1:0);
	}
	public void display(){
		System.out.println(key);
	}
}
