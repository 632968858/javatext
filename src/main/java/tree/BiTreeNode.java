package tree;

public class BiTreeNode {
	private Object data;
	private BiTreeNode rchild,lchild;
	public BiTreeNode (Object data){
		this(data,null,null);
	}
	public BiTreeNode (Object data,BiTreeNode lchild,BiTreeNode rchild){
		this.data=data;
		this.rchild=rchild;
		this.lchild=lchild;
	}
	public void setData(Object o){
		this.data=o;
	}
	public void setRchild(BiTreeNode r){
		this.rchild=r;
	}
	public void setLchild(BiTreeNode r){
		this.lchild=r;
	}
	public Object getData(){
		return data;
	}
	public BiTreeNode getRchild(){
		return rchild;
	}
	public BiTreeNode getLchild(){
		return lchild;
	}
	
	
}
