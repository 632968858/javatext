package basejava;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] s = new String[t];
		sc.nextLine();
		for (int i = 0; i < t; i++) {
			s[i] = sc.nextLine();
		}
		for (int j = 0; j < t; j++) {
			String s1 = s[j].toLowerCase(); // 变小
			System.out.println(s1);
			int sum = 0;
			int pre = 0; // 前边一个
			int len = 0;
			for (int i = 0; i < s1.length(); i++) {
				char s2 = s1.charAt(i);
				if (s2 >= 'A' && s2 <= 'Z') {
				} else {
					System.out.println("1");
					int a = s2 - 'a' + 1;
					if (i == 0) {
						pre = s1.charAt(0);
					}
					if (pre == s2) {
						len++;
						System.out.println("2");
					} else {
						System.out.println("3");
						sum += len * len * pre;
						len = 0;
					}
					pre = s2;
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}

}
