package spring.test;

public class TestSingleton {
    public static void main(String[] args) {
        PlayMusic playMusic = PlayMusic.getInstance();
        playMusic.play();

        // 返回的是同一个对象
        System.out.println(playMusic.equals(PlayMusic.getInstance()));

        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.getName());

        // 返回的是同一个对象
        System.out.println(singleton.equals(Singleton.getInstance()));
    }
}
