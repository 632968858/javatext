package tree;

import java.util.LinkedList;

public class BiTree {
	private BiTreeNode root; //根节点
	public BiTree() {
		// TODO Auto-generated constructor stub
		this.root=null;
	}
	public BiTree(String preOrder,String inOrder,int pre,int in,int count){//前序和中序确定二叉树，pre,in为各序列起点，count为个数
		if(count>0){
			char r=preOrder.charAt(pre);
			int i=in;
			for(;i<count;i++)
			{
				if(r==inOrder.charAt(i))              //根节点在中序中的位置
					break;
			}
			root=new BiTreeNode(r);
			root.setLchild(new BiTree(preOrder,inOrder,pre+1,in,i).root);//左孩子,子树
			root.setRchild(new BiTree(preOrder,inOrder,pre+i+1,in+i+1,count-i-1).root);//右子树
		}
	}
	public void preRootTraverse(BiTreeNode root){    //先序遍历递归
		if(root!=null){
			System.out.println(root.getData());
			preRootTraverse(root.getLchild());
			preRootTraverse(root.getRchild());
		}
	}
	public void preRootTraverse(){    //先序遍历非递归利用栈实现
		LinkedList<BiTreeNode> ll =new LinkedList<BiTreeNode>();
		if(root!=null)
		{	
			System.out.println(root.getData());
			ll.push(root);
			while(!ll.isEmpty()){
				if(ll.peek().getLchild()!=null)
				{
					BiTreeNode btn=ll.peek().getLchild();
					System.out.println(btn.getData());
					ll.push(btn);
				}else{
					
					if(ll.peek().getRchild()!=null){
						
						System.out.println(ll.peek().getRchild().getData());
						ll.push(ll.peek().getRchild());
					}else{
						ll.pop();
					}
				}
			}
		}
	}
	public void inRootTraverse(BiTreeNode root){    //中序遍历递归
		if(root!=null){
			
			inRootTraverse(root.getLchild());
			System.out.println(root.getData());
			inRootTraverse(root.getRchild());
			}	
		
	}
}
