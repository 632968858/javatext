package designpattern;

/**
 * @Author liuxiaoyu
 * @Date 17/3/31.
 */
public class SingletonPatternFour {
    private SingletonPatternFour() {
    }

    public static class SingletonHolder {
        private static volatile SingletonPatternFour singletonPatternFour = new SingletonPatternFour();

        public static SingletonPatternFour getInstance() {
            return singletonPatternFour;
        }
    }

    public static SingletonPatternFour getInstance() {
        return SingletonHolder.getInstance();
    }

}
