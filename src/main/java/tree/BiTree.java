package tree;

import java.util.BitSet;
import java.util.LinkedList;

public class BiTree {
	private BiTreeNode root; //根节点
	public BiTree() {
		// TODO Auto-generated constructor stub
		this.root=null;
	}
	public void postRootTraverse(){//后序遍历非递归
		LinkedList<BiTreeNode> stack = new LinkedList<BiTreeNode>();
		BiTreeNode btn=root ;
		BiTreeNode pre=null;  //pre 为最近访问的节点
		while(btn!=null){
			while(btn.getLchild()!=null){
				stack.push(btn);
				btn=btn.getLchild();
		}
		while(btn!=null&&(btn.getRchild()==null||btn.getRchild().equals(pre))){
			System.out.print(btn.getData());
			pre=btn;
			if(stack.isEmpty())return;/////////////////
			btn=stack.pop();//////////////////
		}
		stack.push(btn);
		btn=btn.getRchild();
		}
	}
	public void levelTraverse(){ //层次遍历
		if(root==null)return ;
		LinkedList<BiTreeNode> queue=new LinkedList<BiTreeNode>();
		BiTreeNode btn ;
		queue.offer(root);
		while(!queue.isEmpty()){
			btn =queue.poll();
			System.out.print(btn.getData());
			if(btn.getLchild()!=null)
				queue.offer(btn.getLchild());
			if(btn.getRchild()!=null)
				queue.offer(btn.getRchild());
		}
	}
	public BiTreeNode searchNode(BiTreeNode root,Object target){   //二叉树查找
		if(root!=null){
			if(root.getData().equals(target)){
				return root;
			}
			else{
				root = searchNode(root.getLchild(), target);
				return (root!=null)?root : searchNode(root.getRchild(), target);
			}
		}
		return null;
	}
	public int count(BiTreeNode root){ //统计个数递归，或者用层次遍历
		int count=0;
		if(root!=null)
		{	
			count++;
			count+=count(root.getLchild());
			count+=count(root.getRchild());
			
		}
		return count;
	}
	public int deep(BiTreeNode root){ //求二叉树的深度
		int deep=0;
		if(root!=null)
		{
			deep++;
			int ldeep=deep(root.getLchild());
			int rdeep=deep(root.getRchild());
			deep+=ldeep>rdeep?ldeep:rdeep;
		}
		return deep;
		
	}
	public BiTree(String preOrder,String inOrder,int pre,int in,int count){//前序和中序确定二叉树，pre,in为各序列起点，count为个数
		if(count>0){
			char r=preOrder.charAt(pre);
			int i=0;
			for(;i<count;i++)                      //i相当于计数下一轮的个数
			{
				if(r==inOrder.charAt(i+in))              //都是相对位置根节点在中序中的位置
					break;
			}
			root=new BiTreeNode(r);
			root.setLchild(new BiTree(preOrder,inOrder,pre+1,in,i).root);//左孩子,子树
			root.setRchild(new BiTree(preOrder,inOrder,pre+i+1,in+i+1,count-i-1).root);//右子树count-1为边界
		}
	}
	public void preRootTraverse(BiTreeNode root){    //先序遍历递归
		if(root!=null){
			System.out.print(root.getData());
			preRootTraverse(root.getLchild());
			preRootTraverse(root.getRchild());
		}
	}
	public void preRootTraverse(){    //先序遍历非递归利用栈实现
		LinkedList<BiTreeNode> stack =new LinkedList<BiTreeNode>();
		BiTreeNode btn=root ;
		while(!stack.isEmpty()||btn!=null){
			if(btn!=null){
				System.out.print(btn.getData());
				stack.push(btn);
				btn=btn.getLchild();
			}else{
				btn=stack.pop();
				btn=btn.getRchild();
			}
		}
	}
	
	public void inRootTraverse(BiTreeNode root){    //中序遍历递归
		if(root!=null){
			inRootTraverse(root.getLchild());
			System.out.print(root.getData());
			inRootTraverse(root.getRchild());
			}	
		
	}
	public void inRootTraverse(){    //中序遍历非递归
		BiTreeNode btn =root;
		LinkedList<BiTreeNode> stack =new LinkedList<BiTreeNode>();
		while(!stack.isEmpty()||btn!=null){
			if(btn!=null){
				stack.push(btn);
				btn=btn.getLchild();
			}else{
				btn=stack.pop();
				System.out.print(btn.getData());
				btn=btn.getRchild();
			}
		}
	}
	public void postRootTraverse(BiTreeNode root){//后序遍历递归
		if(root!=null){
			postRootTraverse(root.getLchild());
			postRootTraverse(root.getRchild());
			System.out.print(root.getData());
		}
	}
	/*public void postRootTraverse(){//后序遍历非递归
		LinkedList<BiTreeNode> stack =new LinkedList<BiTreeNode>();
		BiTreeNode btn;
		BiTreeNode p;
		BiTreeNode pre=null;//指向前一个被访问的节点
		stack.push(root);
		while(!stack.isEmpty()){
			btn=stack.peek();
			可以访问当前节点的条件：
			 * 1.没有左右孩子
			 * 2.有一个孩子且被访问
			 * 3.左或右孩子未被访问过
			 * 前两种情况，说明该节点可以访问
			 * 
			 * 
			if((btn.getLchild()==null&&btn.getRchild()==null)||
					(pre!=null&&pre.equals(btn.getLchild())&&btn.getRchild()==null)
					||(pre!=null&&pre.equals(btn.getRchild())&&btn.getLchild()==null)
					)
			
			if((btn.getLchild()==null&&btn.getRchild()==null)||
					(pre!=null&&((pre.equals(btn.getLchild()))||(pre.equals(btn.getRchild()))
							)))
			{
				System.out.print(btn.getData());
				p=stack.pop();
				pre=btn;
			}else{               //不该访问的时候
				if(btn.getRchild()!=null){ ///////////////////////////
					stack.push(btn.getLchild());
				}
				if(btn.getLchild()!=null){
					stack.push(btn.getRchild());
				}
				
			}
		}
	}*/
	
	public BiTreeNode getRoot(){ return root;}
	public void setRoot(BiTreeNode root){ this.root=root;}
	public static void main(String[] args) {
		String pre="abdegcfh";
		String inOrder="dbgeafhc";
		BiTree t= new BiTree(pre,inOrder,0,0,8);
		System.out.println("先序遍历递归");
		t.preRootTraverse(t.getRoot());;
		System.out.println(" ");
		System.out.println("先序遍历非递归");
		t.preRootTraverse();
		System.out.println(" ");
		System.out.println("中序遍历递归");
		t.inRootTraverse(t.getRoot());
		System.out.println(" ");
		System.out.println("中序遍历非递归");
		t.inRootTraverse();
		System.out.println(" ");
		System.out.println("后序遍历递归");
		t.postRootTraverse(t.getRoot());
		System.out.println(" ");
		System.out.println("后序遍历非递归");
		t.postRootTraverse();
		System.out.println(" ");
		System.out.println("层次遍历非递归");
		t.levelTraverse();
		System.out.println(" ");
		System.out.println("节点个数");
		System.out.print(t.count(t.getRoot()));
		System.out.println(" ");
		System.out.println("深度");
		System.out.print(t.deep(t.getRoot()));
		System.out.println(" ");
	}
}
