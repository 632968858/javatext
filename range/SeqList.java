package range;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Scanner;

public class SeqList {
	private ArrayList<RecordNode> al;
	public SeqList(ArrayList<RecordNode> al){
		this.al=al;
		
	}
	public void insertSort1(){  //插入排序不带哨兵
		RecordNode temp;
		int i,j;
		for(i=0;i<al.size();i++)
		{
			temp=al.get(i);
			for( j=i-1;j>=0&&temp.getKey().compareTo(al.get(j).getKey())<0;j--)
			{
				al.set(j+1,al.get(j));
			}
			al.set(j+1,temp);       ////////////////////////////////////////////////////////////////
		}
	}
	public void insertSort2(){
		int i,j;
		for(i=1;i<al.size();i++)
		{
			al.set(0, al.get(i));
			for(j=i-1;al.get(0).getKey().compareTo(al.get(j).getKey())<0;j--)
			{
				al.set(j+1,al.get(j));
			}
			al.set(j+1, al.get(0));
		}
	}
	public void display(){
		Iterator<RecordNode> it =al.iterator();
		while(it.hasNext())
			it.next().display();
	}
	public static void main(String[] args) {
		System.out.println("顺序表个数：");
		Scanner sc =new Scanner(System.in);
		int n =sc.nextInt();
		ArrayList<RecordNode> r =new ArrayList<RecordNode>();
		for(int i=n-1;i>=0;i--){
			r.add(new RecordNode(new KeyType(i),new Element("hi"+i)));
		}
		Iterator<RecordNode> it =r.iterator();
		while(it.hasNext())
			it.next().display();
		SeqList s=new SeqList(r);
		s.insertSort1();
		s.display();
		sc.close();
	}
	
	
}
