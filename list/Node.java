package list;
/*

*链表节点
*
*/
public class Node {
	private Object elem;
	private Node node;
	public Node(){
		this(null,null); ////// 调用构造函数
	}
	public Node(Object elem,Node node){
		this.elem=elem;
		this.node=node;
	}
	public Node(Object elem){/////
		
		this(elem,null);
	}
	public Node getnext(){
		return node;
	}
	public Object getdata(){
		return elem;
	}
	public void setnext(Node node){
		this.node=node;
	}
	public void setdata(Object elem){
		this.elem=elem;
	}
}
