package spring.test;

/**
 * 单例模式的练习
 * 懒汉式的单例模式
 */
public class PlayMusic {
    private static  PlayMusic playMusic;

    private PlayMusic(){}

    public static  PlayMusic getInstance(){
        if(playMusic == null){
            playMusic = new PlayMusic();
        }
        return playMusic;
    }

    public void play(){
        System.out.println("正在播放音乐");
    }
}

