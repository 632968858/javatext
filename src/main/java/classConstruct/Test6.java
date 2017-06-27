package classConstruct;

/**
 * @Author liuxiaoyu
 * @Date 17/6/6.
 */
public class Test6 {

    public static int i = Test7.j;

    {
        i++;
    }

    static {
        i = 0;
    }

    public Test6() {
        i++;
    }
}
