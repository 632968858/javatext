package basejava;

import java.util.Random;

public class xidan {
	public static void main(String[] args) {
		int[] elem = new int[1000];// 1000
		for (int i = 0; i < 1000; i++) {
			elem[i] = 1;
		}
		Random rand = new Random(100);
		int count = 0;
		int point = 0;
		while (count < 900) {
			point = rand.nextInt(1000);
			if (elem[point] == 1) {
				System.out.print(point+1+" ");
				count++;
			} else {
				elem[point]=0;
				point = rand.nextInt();
			}
		}
	}
}
