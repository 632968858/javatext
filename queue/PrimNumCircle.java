package queue;

import java.util.Scanner;

import list.SqList;

/*将1-n的n个自然数排成环形，使得相邻俩数之和为素数，构成素数环
 * 
 * 
 * */
public class PrimNumCircle {
	public void primnumcircle(SqList sq, LinkQueue lq) {
		while(!lq.isEmpty()){
			
		}
	}

	public static void main(String[] args) throws Exception {
		
		LinkQueue lq = new LinkQueue();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SqList sq = new SqList(n);
		sq.insert(0, 1);
		for (int i = 2; i <= n; i++) {
			lq.offer(i);
		}
		PrimNumCircle pnc = new PrimNumCircle();
		pnc.primnumcircle(sq, lq);
		sc.close();
	}
}
