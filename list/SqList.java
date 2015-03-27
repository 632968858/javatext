package list;

public class SqList implements IList{
	private Object [] listElem;
	private int curLen;  //当前个数
  public SqList(int maxSize) {
	// TODO Auto-generated constructor stub
	  listElem=new Object[maxSize];
	  curLen=0;
}
  
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		curLen=0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return curLen==0;
		
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return curLen;
	}

	@Override
	public Object get(int i) throws Exception {
		// TODO Auto-generated method stub
		if(i<0||i>curLen-1)
			throw new Exception("第"+i+"个元素不存在");
			return listElem[i];
	}

	@Override
	public void insert(int i, Object x) throws Exception{
		// TODO Auto-generated method stub
		if(i<0||i>curLen){
			throw new Exception("插入不合法");
		}
		if(curLen==listElem.length)
			throw new Exception("已满");
		for(int j=curLen;j>i;j--){
			listElem[j]=listElem[j-1];
		}
		listElem[i]=x;
		curLen++;
	}

	@Override
	public void remove(int i) throws Exception {
		// TODO Auto-generated method stub
		if(i<0||i>curLen-1)
			throw new Exception("删除位置不对");
		for(int j=i;j<curLen-1;j++){  //curlen-1
			listElem[j]=listElem[j+1];
		}
		curLen--;
		
	}

	@Override
	public int indexOf(Object x) {
		// TODO Auto-generated method stub
		for(int i=0;i<curLen;i++){
			if(listElem[i].equals(x))
				return i;
		}
		return -1;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		for(Object o:listElem)
		{
			System.out.println(o);
		}
	}

}
