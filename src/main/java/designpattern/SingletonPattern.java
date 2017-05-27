package designpattern;

public class SingletonPattern {

    private SingletonPattern() {
    }

    private volatile  static SingletonPattern union = null;

    public static SingletonPattern getInstance() {
        if (union == null) {
            synchronized (SingletonPattern.class) {
                if (union == null) {
                    union = new SingletonPattern();
                }

            }
        }
        return union;
    }
}
