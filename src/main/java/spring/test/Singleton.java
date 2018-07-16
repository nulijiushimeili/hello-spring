package spring.test;


/**
 * 饿汉单例模式
 */

/**
 * 在对象经常发生改变的时候使用多例模式
 * 在对象永远只是一个的时候使用单例模式
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    private String name = "test";
    private Singleton(){}

    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
