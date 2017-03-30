package tree;
/**
 * 
 * 
 * @author xiaoyu
 *	给定一个二叉排序树的后续遍历，判断是否为后续遍历
 */
public class isPostTree {
	
	public boolean isPost(int [] target,int begin,int end){
		
		boolean tag =false; 
		
		if(target==null||end-begin==0)
			return tag;
		
		//根节点
		int root = target[end]; 
		
		int i,j;
		for(i=begin;i<end;i++){ //找到左子数节点范围的下标i
			if(target[i]>root)
				break;
		}
		for(j=i;j<end;j++){          //如果右子树存在小于跟节点则退出，返回false
			if(target[j]<root)
				return tag;
		}
		
		//判断左右子树是否是后续遍历
		boolean left=true,right=true;
		if(i>begin)
			left =isPost(target,begin,i);
		if(i<end)
			right = isPost(target,i,end);
		return left&&right;
			
	}
	
	public static void main(String[] args) {
		int [] a ={1,4,3,7,9,8,6};
		isPostTree is =new isPostTree();
		System.out.println(is.isPost(a,0,a.length-1));
		
	}
}
