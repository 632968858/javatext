package classConstruct;

/**
 * @Author liuxiaoyu
 * @Date 17/6/6.
 */

public class Test7 extends Test6 {

    public static int j = Test6.i;

    static {
        j++;
    }

    {
        j++;
    }

    public static void main(String[] args) {

        Test7 t7 = new Test7();
        System.out.println("字段I的值是【" + Test6.i + "】");
        System.out.println("字段J的值是【" + Test7.j + "】");
    }
}



