package designpattern;

/**
 * @Author liuxiaoyu
 * @Date 17/3/31.
 */
public class SingletonPatternSecond {

    private static SingletonPatternSecond singletonPatternSecond = new SingletonPatternSecond();

    private SingletonPatternSecond() {
    }

    public static SingletonPatternSecond getInstance() {
        return singletonPatternSecond;
    }
}
