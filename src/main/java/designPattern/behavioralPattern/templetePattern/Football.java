package designPattern.behavioralPattern.templetePattern;

/**
 * @ClassName Football
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:23
 * @Version 1.0
 */
public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("FootBall Game initialize ");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game initialized start playing");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Started. enjoy the game!");
    }
}
