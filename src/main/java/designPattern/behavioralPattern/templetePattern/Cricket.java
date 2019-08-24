package designPattern.behavioralPattern.templetePattern;

/**
 * @ClassName Cricket
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:20
 * @Version 1.0
 */
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game initialized! start playing");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game end!");
    }
}
