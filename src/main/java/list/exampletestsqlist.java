package list;

public class exampletestsqlist {
	public static void main(String[] args) throws Exception {
		int maxSize=10;
		SqList sq=new SqList(maxSize);
		sq.insert(0,'a');
		sq.insert(1,'b');
		sq.insert(2,'c');
		sq.insert(3,'d');
		sq.insert(4,'e');
		System.out.println(sq.length());
		System.out.println(sq.get(3));
		System.out.println(sq.indexOf('c'));
		
		
		
	}
}
