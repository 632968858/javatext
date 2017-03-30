package basejava;

public class OverloadText {
		protected int fun(int a,int b){return 1;}
}

class child extends OverloadText{
	public int fun(int a,int b){return 1;}
	private int fun(int a,long b){return 1;}
	//static 	protected int fun(int a,int b){return 1;}
}
