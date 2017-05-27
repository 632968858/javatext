package designpattern;

/**
 * @Author liuxiaoyu
 * @Date 17/3/31.
 */
public class SingletonPatternThird {
    private SingletonPatternThird() {
    }

    private static SingletonPatternThird singletonPatternThird ;

    public static SingletonPatternThird getInstance(){

        synchronized (SingletonPatternThird.class){
            if (singletonPatternThird == null){
                singletonPatternThird = new SingletonPatternThird();
            }
            return singletonPatternThird;
        }
    }
}
