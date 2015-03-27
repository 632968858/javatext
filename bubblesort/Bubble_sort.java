package bubblesort;

import java.util.Scanner;

public class Bubble_sort {
	public static int[] bubble_sort(int[] a) {
		boolean flag = true;
		for (int i = 0; i < a.length && flag; i++) {
			flag = false;
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					flag = true;
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		int max = 10;
		int[] a = new int[max];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();

		}
		;
		for (int i : bubble_sort(a)) {
			System.out.println(i);
		}
		sc.close();
	}
}
