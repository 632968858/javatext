package queue;

import java.util.Scanner;

import list.SqList;

/*将1-n的n个自然数排成环形，使得相邻俩数之和为素数，构成素数环
 * 
 * 
 * */
public class PrimNumCircle {
	public boolean isprim(int n){
		if(n>=2)
			for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0)
				return false;
			}
		else
			return false;
		return true;
	}
	public SqList primnumcircle(int n) throws Exception{
		if(n%2!=0)
			return null;
		else{
			LinkQueue lq = new LinkQueue();
			SqList sq = new SqList(n);
			sq.insert(0,1);
			for (int i = 2; i <= n; i++) {
				lq.offer(i);
			}
			return insertRing(sq,lq,2,n);////////////////在顺序表中插入第2个数，使其
		}
	}
	public SqList insertRing(SqList sq,LinkQueue lq,int m,int n) throws Exception{    // 插入第m个数在顺序表素数环中，n为总个数
		int count=0;
		while(!lq.isEmpty()&&count<=n-m){ //不为空，且防止在一次循环中多次遍历
			int p=(Integer)sq.get(sq.length()-1);
			int q=(Integer)lq.poll();
			if(m==n){ //最后一个
				if(isprim(p+q)&&isprim(q+1)){
					sq.insert(sq.length(), q);
					return sq;
				}else
					lq.offer(q);
			}else if(isprim(p+q)){  ///不是最后一个
				sq.insert(sq.length(), q);
				if(insertRing(sq, lq, m+1, n)!=null)  //////////尝试若插入可以形成则返回该顺序表素数环
					return sq;
				/////////////////////////////////////如果不成功则退还最后一个数
				sq.remove(sq.length()-1);
				lq.offer(q);/////////////
			}else
				lq.offer(q);
			count++;
		}
			return null;
	}

	public static void main(String[] args) throws Exception {
		
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PrimNumCircle pnc = new PrimNumCircle();
		pnc.primnumcircle(n).display();
		sc.close();
	}
}
