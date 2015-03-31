package stack;

import java.util.Scanner;

/*判断输入分割符是否匹配*/
public class Checkmatch {
	public static boolean isLeftOpe(String c) {
		if (c.equals("{") || c.equals("[") || c.equals("(") || c.equals("/*")) {

			System.out.println(c + "是左符合");
			return true;
		} else
			return false;
	}

	public static boolean isRigtOpe(String c) {
		if (c.equals("}") || c.equals("]") || c.equals(")") || c.equals("*/"))
			return true;
		else
			return false;
	}

	public static boolean match(String s1, String s2) {
		if ((s1.equals("{") && s2.equals("}"))
				|| (s1.equals("[") && s2.equals("]"))
				|| (s1.equals("(") && s2.equals(")"))
				|| (s1.equals("/*") && s2.equals("*/")))
			return true;
		else
			return false;
	}

	@SuppressWarnings("unused")
	public static boolean islegal(String s) throws Exception {
		if (!s.equals(" ") || s != null) {
			Sqstack st = new Sqstack(100);
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				System.out.println(c + "字符判断");
				String sc = String.valueOf(c);
				if (i != st.length()) { // ////////////////////////////////////
					if ((c == '/' && s.charAt(i + 1) == '*') || (c == '*')
							&& s.charAt(i + 1) == '/') {
						sc = sc.concat(String.valueOf(s.charAt(i + 1))); // /////////
						i++;
					}
				}
				if (isLeftOpe(sc)) {
					try {
						System.out.println("压栈" + sc);
						st.push(sc);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (isRigtOpe(sc)) {
					if (st.isEmpty() || !match(st.pop().toString(), sc)) // //////////////////
						return false;
				}
			}
			if (st.isEmpty())
				return true;
			else
				return false;
		} else
			throw new Exception("为空");

	}

	public static void main(String[] args) throws Exception {
		System.out.println("请输入数学表达式：");
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		if (islegal(temp))
			System.out.println("legal");
		else
			System.out.println("not legal");
		sc.close();
	}

}
